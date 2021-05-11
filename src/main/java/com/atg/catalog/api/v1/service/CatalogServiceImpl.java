package com.atg.catalog.api.v1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atg.catalog.api.v1.exception.CatalogNotFoundException;
import com.atg.catalog.api.v1.repository.ICatalogRepository;
import com.atg.catalog.api.v1.resources.CatalogResource;

@Service
public class CatalogServiceImpl implements ICatalogService {
	@Autowired
	ICatalogRepository catalogRepository;

	    /* Getting all */
	    public CatalogResource getCatalogById(Long id) throws CatalogNotFoundException {
	    	return catalogRepository.getCatalogById(id);
	    }

		
		public CatalogResource createCatalog(CatalogResource catalogResource) {
		   return catalogRepository.createCatalog(catalogResource);
		  }
	
		

}
