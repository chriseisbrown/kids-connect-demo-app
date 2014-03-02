package com.kidsconnect.domain.data.impl;

import com.kidsconnect.domain.data.VenueData;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.Venue;


public class PojoVenueData implements VenueData {

    public String name;
    public String address;
    public String venueId;
    
    public Location location;
    

    public PojoVenueData(String id) {
	this.venueId = id;
	this.address = "";
	this.name = "";
    }

    public PojoVenueData(String id, String name, String address) {
	this(id);
	this.address = address;
	this.name = name;
    }

    public PojoVenueData(String id, String name, String address, Location location) {
	this(id, name, address);
	this.location = location;
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

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Venue makeDomainWrapper() {
	return new Venue(this);
    }

    @Override
    public String toString() {
	return "PojoVenueData [name=" + name + ", address=" + address
		+ ", venueId=" + venueId + ", location=" + location + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result
		+ ((location == null) ? 0 : location.hashCode());
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
	if (venueId == null) {
	    if (other.venueId != null)
		return false;
	} else if (!venueId.equals(other.venueId))
	    return false;
	return true;
    }

    
}
