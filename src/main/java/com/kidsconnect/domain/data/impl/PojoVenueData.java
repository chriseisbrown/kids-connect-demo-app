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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (venueId == null) {
	    if (other.venueId != null)
		return false;
	} else if (!venueId.equals(other.venueId))
	    return false;
	return true;
    }

    
}
