package com.jk.sprtest.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.sprtest.dao.ImageDAOImpl;

@Controller
public class FileUploadController {
	
	@Autowired
	private ImageDAOImpl imageDAO;
	
	@RequestMapping(value="/fileupload.htm", method=RequestMethod.GET)
	public String uploadPage(Model model){
		Date date = new Date();
		DateFormat format = SimpleDateFormat.getTimeInstance();
		String formattedDate = format.format(date);
		model.addAttribute("serverTime", formattedDate);		
		return "uploadfile";
	}
}
