package com.kidsconnect.domain.data.impl;

import com.kidsconnect.domain.data.VenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Venue;


public class PojoVenueData implements VenueData {

    public String name;
    public String address;
    public String venueId;
    public Borough borough;
    public PostCode postCode;
    public Location location;
    public String transport;
    public String access;

    public boolean babyChange;
    public boolean liftAccess;	
    public boolean buggyParking;	
    public boolean breastFeeding;	
    public boolean bottleWarming;	
    public boolean vendingMachine;	
    public boolean stepFree;
    public boolean refreshments;
    

    public PojoVenueData(String id, String name) {
	this.venueId = id;
	this.address = "";
	this.name = name;
    }

    public PojoVenueData(String id, String name, String address, Location location) {
	this(id, name);
	this.address = address;
	this.location = location;
    }
    
    public PojoVenueData(String id, String name, String address, Borough borough, PostCode postCode, Location location,
	    		String transport, String access) {
	this(id, name, address, location);
	this.borough = borough;
	this.postCode = postCode;
	
	this.transport = transport;
	this.access = access;
    }

    public PojoVenueData(String venueId, String name, String address, 
	    Borough borough, PostCode postCode, Location location,
	    String transport, String access, boolean babyChange,
	    boolean liftAccess, boolean buggyParking, boolean breastFeeding,
	    boolean bottleWarming, boolean vendingMachine, boolean stepFree,
	    boolean refreshments) {
	super();
	this.name = name;
	this.address = address;
	this.venueId = venueId;
	this.borough = borough;
	this.postCode = postCode;
	this.location = location;
	this.transport = transport;
	this.access = access;
	this.babyChange = babyChange;
	this.liftAccess = liftAccess;
	this.buggyParking = buggyParking;
	this.breastFeeding = breastFeeding;
	this.bottleWarming = bottleWarming;
	this.vendingMachine = vendingMachine;
	this.stepFree = stepFree;
	this.refreshments = refreshments;
    }

    public boolean getBabyChange() {
        return babyChange;
    }

    public boolean getLiftAccess() {
        return liftAccess;
    }

    public boolean getBuggyParking() {
        return buggyParking;
    }

    public boolean getBreastFeeding() {
        return breastFeeding;
    }

    public boolean getBottleWarming() {
        return bottleWarming;
    }

    public boolean getVendingMachine() {
        return vendingMachine;
    }

    public boolean getStepFree() {
        return stepFree;
    }

    public boolean getRefreshments() {
        return refreshments;
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
    
    public Location getLocation() {
        return location;
    }

    public String getVenueId() {
        return venueId;
    }

    public Borough getBorough() {
        return borough;
    }

    public PostCode getPostCode() {
        return postCode;
    }
    
    public String getTransport() {
        return transport;
    }

    public String getAccess() {
        return access;
    }

    @Override
    public Venue makeDomainWrapper() {
	return new Venue(this);
    }

    @Override
    public String toString() {
	return "PojoVenueData [name=" + name + ", address=" + address
		+ ", venueId=" + venueId + ", borough=" + borough
		+ ", postCode=" + postCode + ", location=" + location
		+ ", transport=" + transport + ", access=" + access
		+ ", babyChange=" + babyChange + ", liftAccess=" + liftAccess
		+ ", buggyParking=" + buggyParking + ", breastFeeding="
		+ breastFeeding + ", bottleWarming=" + bottleWarming
		+ ", vendingMachine=" + vendingMachine + ", stepFree="
		+ stepFree + ", refreshments=" + refreshments + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((borough == null) ? 0 : borough.hashCode());
	result = prime * result
		+ ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result
		+ ((postCode == null) ? 0 : postCode.hashCode());
	result = prime * result + ((venueId == null) ? 0 : venueId.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	PojoVenueData other = (PojoVenueData) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (borough == null) {
	    if (other.borough != null)
		return false;
	} else if (!borough.equals(other.borough))
	    return false;
	if (location == null) {
	    if (other.location != null)
		return false;
	} else if (!location.equals(other.location))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (postCode == null) {
	    if (other.postCode != null)
		return false;
	} else if (!postCode.equals(other.postCode))
	    return false;
	if (venueId == null) {
	    if (other.venueId != null)
		return false;
	} else if (!venueId.equals(other.venueId))
	    return false;
	return true;
    }

    
}
