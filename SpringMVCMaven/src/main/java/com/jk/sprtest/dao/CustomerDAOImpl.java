package com.jk.sprtest.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jk.sprtest.dao.jdbc.CustomerRowMapper;
import com.jk.sprtest.dao.queries.CustomerQueries;
import com.jk.sprtest.model.CustomerVO;

public class CustomerDAOImpl {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void addCustomer(CustomerVO customerVO) {
		System.out.println("CustomerDAOImpl.addCustomer() jdbcTemplate ->" + jdbcTemplate);		
		Object[] inputs = new Object[] { customerVO.getName(),
										 customerVO.getEmail(), 
										 customerVO.getAge(),
										 customerVO.getGender(), 
										 customerVO.getBirthDay() 
									};
		
		jdbcTemplate.update(CustomerQueries.CUSTOMER_INSERT_SQL, inputs, CustomerQueries.INPUT_TYPES);
	}
	
	public List<CustomerVO> getAllCustomers(){
		List<CustomerVO> customersList = (List<CustomerVO>) jdbcTemplate.query(CustomerQueries.GET_ALL_CUSTOMERS_SQL, new CustomerRowMapper());
		System.out.println("CustomerDAOImpl.getAllCustomers() - " +customersList);
		return customersList;
	}
}
