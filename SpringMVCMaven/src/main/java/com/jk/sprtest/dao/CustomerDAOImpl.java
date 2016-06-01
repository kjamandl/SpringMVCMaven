package com.jk.sprtest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jk.sprtest.dao.queries.DBQueries;
import com.jk.sprtest.model.CustomerVO;
import com.jk.sprtest.model.CustomerVO.Gender;

public class CustomerDAOImpl {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addCustomer(CustomerVO customerVO) {
		System.out.println("CustomerDAOImpl.addCustomer() jdbcTemplate ->"+ jdbcTemplate);
		Object[] inputs = new Object[] { customerVO.getName(),customerVO.getEmail(), customerVO.getAge(),customerVO.getGender(), customerVO.getBirthDay() };

		jdbcTemplate.update(DBQueries.CUSTOMER_INSERT_SQL, inputs,DBQueries.INPUT_TYPES);
	}

	public List<CustomerVO> getAllCustomers() {
		List<CustomerVO> customersList = (List<CustomerVO>) jdbcTemplate.query(DBQueries.GET_ALL_CUSTOMERS_SQL, new CustomerRowMapper());
		System.out.println("CustomerDAOImpl.getAllCustomers() - "+ customersList);
		return customersList;
	}

	private class CustomerRowMapper implements RowMapper<CustomerVO> {
		public CustomerVO mapRow(ResultSet rs, int rownum) throws SQLException {
			System.out.println("CustomerRowMapper.mapRow()" + rownum);
			CustomerVO customerVO = new CustomerVO();
			customerVO.setName(rs.getString("name"));
			customerVO.setEmail(rs.getString("email"));
			customerVO.setAge(rs.getInt("age"));
			customerVO.setGender(Gender.valueOf(rs.getString("gender")));
			customerVO.setBirthDay(rs.getDate("birthDay"));
			return customerVO;
		}

	}
}
