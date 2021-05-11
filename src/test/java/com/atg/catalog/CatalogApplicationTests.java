package com.atg.catalog;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.assertNotNull;
import static  org.junit.jupiter.api.Assertions.assertNull;
import static  org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.atg.catalog.api.v1.CatalogApi;
import com.atg.catalog.api.v1.CatalogItemApi;
import com.atg.catalog.api.v1.resources.CatalogItem;
import com.atg.catalog.api.v1.resources.CatalogResource;
import com.atg.catalog.api.v1.service.ICatalogService;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class CatalogApplicationTests {
	
	RestTemplate restTemplate=new RestTemplate();
	
	@Autowired
	CatalogApi catalogApi;
	
	@Autowired
	CatalogItemApi catalogItemApi;
	
  @Test
  void contextLoads() {
  }

 
  
  private String getServiceBaseUrl() {
		return "http://localhost:8080" ;
	}
 
  @Test
	public void testgetCatalogById() {
	  
	  ResponseEntity<CatalogResource> catalogResource=catalogApi.getCatalogById(1L);
			//  restTemplate.getForObject(getServiceBaseUrl() + "/v1/catalogs/1", CatalogResource.class);
	  assertNotNull(catalogResource.getBody());
	}

 
  
  @Test
 	public void testgetAllItemsByCatalogId() {

		List<CatalogItem> listItems= catalogItemApi.getAllItemsByCatalogId(1L);
 		assertNotNull(listItems);
 	}
  
  @Test
	public void testgetAllItemsByCatalogIdNotFound() {
	  List<CatalogItem> listItems= catalogItemApi.getAllItemsByCatalogId(9L);
		assertNotNull(listItems);
		//assertNotNull(listItems.getBody());
	}

  @Test
	public void testCreateCatalog() {
	  CatalogResource catalogResource = new CatalogResource();
	  catalogResource.setName("Heavy Materil");
      catalogResource.setDescription("High lifting Equipment");
      catalogResource.setReferenceId("H-Hvy-Mat");
      catalogResource= catalogApi.createCatalog(catalogResource);	  
      assertNotNull(catalogResource.getId());
		
		
  }
  
  @Test
	public void testCreateCatalogItem() {
	  CatalogItem catalogeItem = new CatalogItem();
	  catalogeItem.setName("Injectors");
	  catalogeItem.setDescription("Fuel Injectors for traction motors");
	  catalogeItem.setReferenceId("F-Inject-Motors");
	  catalogeItem.setPrice(new BigDecimal(183.00));
	  catalogeItem.setCatalogId(1L);
	  catalogeItem=  catalogItemApi.addItemToCatalog(catalogeItem);

	   assertNotNull(catalogeItem.getId());
	}
 
}
