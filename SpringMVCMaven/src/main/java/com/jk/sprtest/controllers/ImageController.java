package com.jk.sprtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.sprtest.dao.ImageDAOImpl;

@Controller
public class ImageController {
	
	@Autowired
	private ImageDAOImpl imageDAO;
	
	@RequestMapping(value="/image.htm", method=RequestMethod.GET)
	@ResponseBody
	public byte[] getImageByName(@RequestParam("id") Integer id){
		System.out.println("ImageController.getImageByName()" +id);
		return imageDAO.loadImage(id);
		
	}
}
