package com.atg.catalog.api.v1.repository;

import com.atg.catalog.api.v1.exception.CatalogNotFoundException;
import com.atg.catalog.api.v1.resources.CatalogResource;

public interface ICatalogRepository {
	
	  CatalogResource getCatalogById(Long id) throws CatalogNotFoundException;
	  CatalogResource createCatalog(CatalogResource catalogResource) ;
		   

}
