package com.kidsconnect.domain.data.impl;

import com.kidsconnect.domain.data.VenueData;
import com.kidsconnect.domain.model.Venue;


public class PojoVenueData implements VenueData {

    public String name;
    public String address;
    public String venueId;
    
    
    public PojoVenueData(String id) {
	super();
	this.venueId = id;
	this.address = "";
	this.name = "";
    }

    public PojoVenueData(String id, String name, String address) {
	super();
	this.venueId = id;
	this.address = address;
	this.name = name;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getAddress() {
	return address;
    }

    @Override
    public String getId() {
	return venueId;
    }

    @Override
    public Venue makeDomainWrapper() {
	return new Venue(this);
    }

    @Override
    public String toString() {
	return "PojoVenueData [name=" + name + ", address=" + address
		+ ", venueId=" + venueId + "]";
    }

    
}
