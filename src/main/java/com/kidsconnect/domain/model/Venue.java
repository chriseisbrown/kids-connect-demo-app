package com.kidsconnect.domain.model;

import com.kidsconnect.domain.data.VenueData;


public class Venue implements DomainClass
{
    private VenueData delegate;
    
    public Venue(VenueData delegate)
    {
	this.delegate = delegate;
    }  

    public String getName(){
	return delegate.getName();
    }
    
    public String getAddress(){
	return delegate.getAddress();
    }

    public String getId() {
	return delegate.getId();
    }

    public Location getLocation() {
 	return delegate.getLocation();
    }

    public Borough getBorough() {
 	return delegate.getBorough();
    }
    
    public PostCode getPostCode() {
 	return delegate.getPostCode();
    }

    public String getTransport() {
 	return delegate.getTransport();
    }

    public String getAccess(){
	return delegate.getAccess();
    }
    
    @Override
    public String toString() {
	return "Venue [delegate=" + delegate + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((delegate == null) ? 0 : delegate.hashCode());
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
	Venue other = (Venue) obj;
	if (delegate == null) {
	    if (other.delegate != null)
		return false;
	} else if (!delegate.equals(other.delegate))
	    return false;
	return true;
    }
    
}
