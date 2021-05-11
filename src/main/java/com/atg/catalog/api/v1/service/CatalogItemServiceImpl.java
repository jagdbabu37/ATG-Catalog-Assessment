package com.atg.catalog.api.v1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atg.catalog.api.v1.exception.CatalogNotFoundException;
import com.atg.catalog.api.v1.repository.ICatalogItemRepository;
import com.atg.catalog.api.v1.resources.CatalogItem;

@Service
public class CatalogItemServiceImpl  implements ICatalogItemService{
	
	@Autowired
	ICatalogItemRepository catalogItemRepository;
	    
	
		public CatalogItem createCatalogItem(CatalogItem item) {
		    return catalogItemRepository.createCatalogItem(item);
		   
		  }
		
		/* Getting all */
	    public List<CatalogItem> getItemsByCatalogId(Long catalogId) throws CatalogNotFoundException {
	    	 return catalogItemRepository.getItemsByCatalogId(catalogId);
	    }

}
