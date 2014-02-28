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

    @Override
    public String toString() {
	return "Venue [delegate=" + delegate + "]";
    }
    
}
