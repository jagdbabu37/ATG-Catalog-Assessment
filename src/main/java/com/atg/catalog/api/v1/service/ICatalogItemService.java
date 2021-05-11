package com.atg.catalog.api.v1.service;

import java.util.List;


import com.atg.catalog.api.v1.resources.CatalogItem;


public interface ICatalogItemService {
	
	CatalogItem createCatalogItem(CatalogItem item);
	List<CatalogItem> getItemsByCatalogId(Long catalogId) ;
		
		  
		   

}
