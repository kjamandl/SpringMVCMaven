package com.jk.sprtest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.jk.sprtest.dao.queries.DBQueries;
import com.jk.sprtest.model.LocationVO;

@Repository
public class LocationDAOImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addLocations(final List<LocationVO> locationsList) {
		System.out.println("LocationDAOImpl.addLocations()");
		jdbcTemplate.batchUpdate(DBQueries.LOCATIONS_INSERT_SQL,
				new BatchPreparedStatementSetter() {

					public void setValues(PreparedStatement pstment, int index)
							throws SQLException {
						LocationVO locationVO = locationsList.get(index);
						pstment.setString(1, locationVO.getArea());
						pstment.setString(2, locationVO.getPincode());
						pstment.setString(3, locationVO.getCity());
						pstment.setString(4, locationVO.getState());
					}

					public int getBatchSize() {
						return locationsList.size();
					}
				});
		System.out.println("LocationDAOImpl.addLocations() 2");
	}

	public List<LocationVO> getAllLocations() {

		/*
		 * List<CustomerVO> customersList = (List<CustomerVO>)
		 * jdbcTemplate.query(DBQueries.GET_ALL_LOCATIONS_SQL, new
		 * CustomerRowMapper());
		 * System.out.println("CustomerDAOImpl.getAllCustomers() - "+
		 * customersList); return customersList;
		 */

		@SuppressWarnings("unchecked")
		List<LocationVO> locationsList = (List<LocationVO>) jdbcTemplate.query(
				DBQueries.GET_ALL_LOCATIONS_SQL,
				new ResultSetExtractor<List<LocationVO>>() {

					public List<LocationVO> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<LocationVO> locationList = new ArrayList();
						while (rs.next()) {
							LocationVO locationVO = new LocationVO();
							locationVO.setLocationId(rs.getInt("location_id"));
							locationVO.setArea(rs.getString("area"));
							locationVO.setPincode(rs.getString("pincode"));
							locationVO.setCity(rs.getString("city"));
							locationVO.setState(rs.getString("state"));
							locationList.add(locationVO);
						}
						return locationList;
					}
				});
		return locationsList;
	}

}
