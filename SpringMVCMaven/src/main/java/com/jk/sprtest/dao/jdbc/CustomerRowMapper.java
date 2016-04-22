package com.jk.sprtest.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jk.myapp.model.CustomerVO;
import com.jk.myapp.model.CustomerVO.Gender;

public class CustomerRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		System.out.println("CustomerRowMapper.mapRow()"+ rownum);
		CustomerVO customerVO = new CustomerVO();
		customerVO.setName(rs.getString("name"));
		customerVO.setEmail(rs.getString("email"));
		customerVO.setAge(rs.getInt("age"));
		
		customerVO.setGender(Gender.valueOf(rs.getString("gender")));
		customerVO.setBirthDay(rs.getDate("birthDay"));
		return customerVO;
	}

}
