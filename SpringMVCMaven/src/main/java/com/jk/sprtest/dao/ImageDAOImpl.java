package com.jk.sprtest.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jk.sprtest.dao.queries.DBQueries;

@Repository
public class ImageDAOImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public byte[] loadImage(Integer imageId) {
		System.out.println("ImageDAOImpl.loadImage()");
		byte[] image = jdbcTemplate.queryForObject(DBQueries.GET_HEADER_LOGO+imageId, new RowMapper<byte[]>() {

			public byte[] mapRow(ResultSet rs, int rownum) throws SQLException {
				Blob image = rs.getBlob("image"); 
				return image.getBytes(1, (int) image.length());
			}
		});
		System.out.println("ImageDAOImpl.loadImage()" +image) ;
		return image;
	}

	
}
