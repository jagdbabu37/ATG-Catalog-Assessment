package com.atg.catalog.api.v1.repository;

public interface QueryManager {
	
	public static final String SELECT_CATALOG_BY_CATALOG_ID="select id,name,description,referenceId from catalog where id=?";
	public static final String SELECT_CATALOG_ITEM_BY_CATALOG_ID="select id,name,description,referenceId,price,catalogId from item where catalogId=?";
	public static final String CREATE_CATALOG="INSERT INTO catalog (name,description,referenceId) VALUES(?,?,?)";
	public static final String CREATE_CATALOG_ITEM= "INSERT INTO item (name,description,referenceId,price,catalogId) VALUES(?,?,?,?,?)";
}
