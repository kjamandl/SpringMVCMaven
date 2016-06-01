package com.jk.sprtest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jk.sprtest.dao.LocationDAOImpl;
import com.jk.sprtest.model.LocationVO;
import com.jk.sprtest.model.LocationsForm;

@Controller
public class LocationController {
	
	@Autowired
	LocationDAOImpl locationDAO;

	@RequestMapping(value = "/locations.htm", method = RequestMethod.GET)
	public String locationHome(Model model) {
		model.addAttribute("locationsForm", populateEmptyModel() );
		
		LocationsForm existingLocations = new LocationsForm(); 
		existingLocations.setLocations(locationDAO.getAllLocations());
		model.addAttribute("existingLocations", existingLocations);		
		return "locations";
	}
	
	@RequestMapping(value ="/locationSave.htm")
	public String saveLocations(@ModelAttribute("locationsForm") LocationsForm locationsForm, BindingResult result, Model model){
		
		System.out.println("LocationController.saveLocations()" +locationsForm);
		locationDAO.addLocations(locationsForm.getLocations());
		
		LocationsForm existingLocations = new LocationsForm();
		List<LocationVO> locationsList = new ArrayList();
		locationsList = locationDAO.getAllLocations();
		
		existingLocations.setLocations(locationsList);
		
		model.addAttribute("existingLocations", existingLocations);
		return "locations";
	}
	
	

	public LocationsForm populateEmptyModel() {
		List<LocationVO> locationsList = new ArrayList();
		LocationsForm locationsVO = new LocationsForm();
		LocationVO locationVO = new LocationVO();
		locationVO.setLocationId(1);
		locationVO.setArea("");
		locationVO.setPincode("");
		locationVO.setCity("");
		locationVO.setState("");
		locationsList.add(locationVO);
		locationsVO.setLocations(locationsList);
		return locationsVO;
	}
}
