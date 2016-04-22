package com.jk.sprtest.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jk.sprtest.model.User;



@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(Model model){
		Date date = new Date();
		DateFormat format = SimpleDateFormat.getTimeInstance();
		String formattedDate = format.format(date);
		model.addAttribute("serverTime", formattedDate);
		logger.info("Welcome home, The client locale is ->");
		return "home";
	}
	
	@RequestMapping(value="/loginPage",method=RequestMethod.GET)
	public String loginPage(Model model){
	return "login";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String login(@Validated User user,Model model){
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
