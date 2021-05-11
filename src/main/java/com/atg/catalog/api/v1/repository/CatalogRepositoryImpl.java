package com.atg.catalog.api.v1.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import com.atg.catalog.api.v1.resources.CatalogResource;
import com.atg.catalog.api.v1.resources.CatalogItem;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.atg.catalog.api.v1.exception.CatalogNotFoundException;

import java.util.List;

@Repository
public class CatalogRepositoryImpl implements ICatalogRepository {
	
	 @Autowired
	 JdbcTemplate template;

	    /* Getting all */
	    public CatalogResource getCatalogById(Long id) throws CatalogNotFoundException {
	    	try {
	        List<CatalogResource> items = template.query(QueryManager.SELECT_CATALOG_BY_CATALOG_ID ,new Object[]{id}, (result,
	                rowNum) -> new CatalogResource()
	        		 .setId(result.getLong("id"))
	        	     .setName( result.getString("name"))
	        	     .setDescription( result.getString("description"))
	        	     .setReferenceId( result.getString("referenceId"))
	        	     );
	        return items.get(0);
	    	}catch(Exception e) {
	        	throw new CatalogNotFoundException("Catalog Not Found");
	        }
	    }

		
		public CatalogResource createCatalog(CatalogResource catalogResource) {
		    String insertSql = QueryManager.CREATE_CATALOG;
		  try {
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    template.update(connection -> {
		      PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
		      ps.setString(1, catalogResource.getName());
		      ps.setString(2, catalogResource.getDescription());
		     ps.setString(3, catalogResource.getReferenceId());
		      
		      return ps;
		    }, keyHolder);
		    catalogResource.setId(keyHolder.getKey().longValue());
		 }catch(Exception e) {
		    	
		    }
		    return catalogResource;
		  }
	
		

}
