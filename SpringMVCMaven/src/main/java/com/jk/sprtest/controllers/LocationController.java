package com.jk.sprtest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.sprtest.dao.LocationDAOImpl;
import com.jk.sprtest.model.LocationTag;
import com.jk.sprtest.model.LocationVO;
import com.jk.sprtest.model.LocationsForm;

@Controller
public class LocationController {
	
	@Autowired
	LocationDAOImpl locationDAO;

	@RequestMapping(value = "/locations.htm", method = RequestMethod.GET)
	public String locationHome(Model model, HttpServletRequest request) {
		model.addAttribute("locationsForm", populateEmptyModel() );
		
		LocationsForm existingLocations = new LocationsForm();
		
		List<LocationVO> allLocations = locationDAO.getAllLocations(); 
		existingLocations.setLocations(allLocations);
		model.addAttribute("existingLocations", existingLocations);
		
		request.getSession().setAttribute("allLocations", extractLocations(allLocations));
		return "locations";
	}
	
	private List<LocationTag> extractLocations(List<LocationVO> allLocations) {
		List<LocationTag> locationNamesList = new ArrayList();
		for(LocationVO locationVO:allLocations){
			locationNamesList.add(new LocationTag(locationVO.getLocationId(),locationVO.getArea()));
		}
		return locationNamesList;
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
	
	@RequestMapping(value ="/getLocationTags.htm", method=RequestMethod.GET)
	public @ResponseBody List<LocationTag> getLocationNames(@RequestParam String locationName, HttpServletRequest request){
		System.out.println("LocationController.getLocationNames()");
		List<LocationTag> suggestedLocations = new ArrayList();
		List<LocationTag> allLocations = (List<LocationTag>) request.getSession().getAttribute("allLocations");
		
		for (LocationTag locationTag:allLocations){
			if (locationTag.getLocationName().contains(locationName)){
				suggestedLocations.add(locationTag);
			}
		}
		return suggestedLocations;
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
