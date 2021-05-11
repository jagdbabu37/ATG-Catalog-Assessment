package com.atg.catalog.api.v1.repository;

import java.util.List;


import com.atg.catalog.api.v1.resources.CatalogItem;


public interface ICatalogItemRepository {
	
	CatalogItem createCatalogItem(CatalogItem item);
	List<CatalogItem> getItemsByCatalogId(Long catalogId) ;
		
		  
		   

}
