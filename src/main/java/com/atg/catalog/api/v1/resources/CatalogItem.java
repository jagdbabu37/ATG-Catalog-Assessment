package com.atg.catalog.api.v1.resources;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
	public class CatalogItem {
	  private Long id;
	  private String name;
	  private String description;
	  private String referenceId;

	  private Long catalogId;
	  private BigDecimal price;
	}


