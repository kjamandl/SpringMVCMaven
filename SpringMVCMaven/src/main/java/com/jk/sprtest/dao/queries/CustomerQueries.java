package com.jk.myapp.utils;

import java.sql.Types;

public class CustomerQueries {
	public static final String CUSTOMER_INSERT_SQL = "Insert into JK_CUSTOMERS (CUSTOMER_ID,NAME,EMAIL,AGE,GENDER,BIRTHDAY,LAST_UPDATED_DATE) "
			+ "	values (JK_CUSTOMER_SEQ.NEXTVAL,?,?,?,?,?,sysdate)";
	public static final int[] INPUT_TYPES = new int[] { Types.VARCHAR,
			Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.DATE };
	public static final String GET_ALL_CUSTOMERS_SQL = "SELECT * FROM JK_CUSTOMERS";
}
