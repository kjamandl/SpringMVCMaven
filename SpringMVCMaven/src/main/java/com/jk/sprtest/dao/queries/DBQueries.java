package com.jk.sprtest.dao.queries;

import java.sql.Types;

public class DBQueries {
	public static final String CUSTOMER_INSERT_SQL = "Insert into JK_CUSTOMERS (CUSTOMER_ID,NAME,EMAIL,AGE,GENDER,BIRTHDAY,LAST_UPDATED_DATE) "
			+ "	values (JK_CUSTOMER_SEQ.NEXTVAL,?,?,?,?,?,sysdate)";
	public static final int[] INPUT_TYPES = new int[] { Types.VARCHAR,
			Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.DATE };
	public static final String GET_ALL_CUSTOMERS_SQL = "SELECT * FROM JK_CUSTOMERS";
	
	public static final String GET_HEADER_LOGO = "SELECT IMAGE FROM JK_IMAGES WHERE ID=";
	
	public static final String LOCATIONS_INSERT_SQL = "INSERT INTO JK_HCARE_LOCATIONS (LOCATION_ID,AREA,PINCODE,CITY,STATE) "
			+ "	values (JK_LOCATION_SEQ.NEXTVAL,?,?,?,?)";
	
	public static final String GET_ALL_LOCATIONS_SQL = "SELECT * FROM JK_HCARE_LOCATIONS";
}
