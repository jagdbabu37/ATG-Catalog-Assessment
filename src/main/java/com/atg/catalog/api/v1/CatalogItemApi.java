package com.atg.catalog.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atg.catalog.api.v1.resources.CatalogItem;
import com.atg.catalog.api.v1.service.ICatalogItemService;

@RestController
public class CatalogItemApi {
	
	
	@Autowired
	ICatalogItemService catalogItemService;
	/*
	 * End pint  to retrieve list of  item  details by catalog id
	 */
	 
	@GetMapping("/v1/catalogs/items/{id}")
	  public List<CatalogItem> getAllItemsByCatalogId(@PathVariable long id) {
		 return catalogItemService.getItemsByCatalogId(id);
		   
	  }
	/*
	 * End pint  to add items to the catalog
	 */
	  
	 @PostMapping("/v1/catalogs/addItem")
	 public CatalogItem addItemToCatalog(@RequestBody CatalogItem item) {
		return catalogItemService.createCatalogItem(item);
	  }

}
