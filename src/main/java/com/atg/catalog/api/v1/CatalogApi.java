package com.atg.catalog.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atg.catalog.api.v1.exception.CatalogNotFoundException;
import com.atg.catalog.api.v1.resources.CatalogResource;
import com.atg.catalog.api.v1.service.ICatalogService;

@RestController
public class CatalogApi {
	@Autowired
	ICatalogService catalogService;
	
	/*
	 * End pint  to retrieve the catalog details by catalog id
	 */
	 @GetMapping("/v1/catalogs/{id}")
	public ResponseEntity<CatalogResource> getCatalogById(@PathVariable long id) {
		  CatalogResource catalogResource=catalogService.getCatalogById(id);
		if (catalogResource==null)
			throw new CatalogNotFoundException("id-" + id);

		
		return new ResponseEntity<>(catalogResource, HttpStatus.OK); 
	}

	 /*
		 * End pint  to create the catalog
		 */
 
  @PostMapping("/v1/catalogs/createCatalog")
   public CatalogResource createCatalog(@RequestBody CatalogResource catalogResource) {
	 
	return catalogService.createCatalog(catalogResource);
  
  }
  
  
}
