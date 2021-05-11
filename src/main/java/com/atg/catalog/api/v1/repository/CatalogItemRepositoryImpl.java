package com.atg.catalog.api.v1.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;

import com.atg.catalog.api.v1.resources.CatalogItem;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.atg.catalog.api.v1.exception.CatalogNotFoundException;

import java.util.List;

@Repository
public class CatalogItemRepositoryImpl  implements ICatalogItemRepository{
	
	 @Autowired
	 JdbcTemplate template;

	    
	
		public CatalogItem createCatalogItem(CatalogItem item) {
		    String insertSql =QueryManager.CREATE_CATALOG_ITEM;
		    try {
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    template.update(connection -> {
		      PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
		      ps.setString(1, item.getName());
		      ps.setString(2, item.getDescription());
		     ps.setString(3, item.getReferenceId());
		     ps.setBigDecimal(4, item.getPrice());
		     ps.setLong(5, item.getCatalogId());
		      
		      return ps;
		    }, keyHolder);
		    item.setId(keyHolder.getKey().longValue());
		    }catch(Exception e) {
		    	
		    }
		    return item;
		  }
		
		/* Getting all */
	    public List<CatalogItem> getItemsByCatalogId(Long catalogId) throws CatalogNotFoundException {
	    	try {
	        List<CatalogItem> items = template.query(QueryManager.SELECT_CATALOG_ITEM_BY_CATALOG_ID ,new Object[]{catalogId}, (result,
	                rowNum) -> new CatalogItem()
	        		 .setId(result.getLong("id"))
	        	     .setName( result.getString("name"))
	        	     .setDescription( result.getString("description"))
	        	     .setReferenceId( result.getString("referenceId"))
	        	     .setPrice( result.getBigDecimal("price"))
	        	     .setCatalogId( result.getLong("catalogId"))
	        	     
	        	     );
	        return items;
	    	}catch(Exception e) {
	        	throw new CatalogNotFoundException("Items Not Found in the Catalog");
	        }
	    }

}
