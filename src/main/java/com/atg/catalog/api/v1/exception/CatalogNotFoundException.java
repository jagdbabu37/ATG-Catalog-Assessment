package com.atg.catalog.api.v1.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatalogNotFoundException  extends RuntimeException {

	public CatalogNotFoundException(String exception) {
		super(exception);
	}
}