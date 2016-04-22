package com.jk.sprtest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jk.sprtest.dao.CustomerDAOImpl;
import com.jk.sprtest.model.CustomerVO;
import com.jk.sprtest.validators.CustomerValidator;

@Controller
public class CustomerController {
	
	@Autowired	
	private CustomerValidator validator;
	
	@Autowired
	CustomerDAOImpl customerDAO;
	
	private void initBinder(WebDataBinder binder){
		binder.addValidators(validator);
	}
	
	@RequestMapping(value="/customerHome",method=RequestMethod.GET)
	public String customerHome(Model model){
		System.out.println("CustomerController.customerHome()");
		CustomerVO customer = new CustomerVO();
		customerDAO.addCustomer(customer);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value="/customerSave",method=RequestMethod.POST)
	public String customerSave(@Valid @ModelAttribute("customer") CustomerVO customer, BindingResult result, Model model){		
		validator.validate(customer, result);
		System.out.println("CustomerController.customerHome() - errors - " +result.hasErrors() );
		customerDAO.addCustomer(customer);
		return "customer";
	}
	
	
	
}
