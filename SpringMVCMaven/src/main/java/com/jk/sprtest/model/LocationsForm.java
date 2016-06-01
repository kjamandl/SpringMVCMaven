package com.jk.sprtest.model;

import java.util.ArrayList;
import java.util.List;

public class LocationsForm {
	private List<LocationVO> locations = new ArrayList();

	public List<LocationVO> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationVO> locations) {
		this.locations = locations;
	}
}
