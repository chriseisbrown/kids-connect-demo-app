package com.kidsconnect.domain.model;

import org.codehaus.jackson.map.annotate.JsonView;


import com.kidsconnect.domain.data.ActivityData;
import com.kidsconnect.domain.external.DomainView;


public class Activity implements DomainClass
{
    private ActivityData delegate;
    
    public Activity(ActivityData delegate)
    {
	this.delegate = delegate;
    }  
    
    @JsonView(DomainView.Master.class)
    public String getName(){
	return delegate.getName();
    }
    
    @JsonView(DomainView.Deep.class)
    public String getId() {
	return delegate.getId();
    }

    public ActivityType getType() {
	return delegate.getType();
    }

    
    public AgeRange getAgeRange() {
	return delegate.getAgeRange();
    }
    
    public String getDescription(){
	return delegate.getDescription();
    }

    public String getNarrative(){
	return delegate.getNarrative();
    }

    public String getVenueId(){
	return delegate.getVenueId();
    }
    
    public String getVenueName(){
	return delegate.getVenueName();
    }
    
    public boolean getBookingRequired(){
	return delegate.getBookingRequired();
    }
    
    public String getBookingNarrative(){
	return delegate.getBookingNarrative();
    }     
    
    public boolean getFreeOfCharge(){
	 return delegate.getFreeOfCharge();
    }
    
    // CMB - annotate this property just to experiment with JsonViews
    @JsonView(DomainView.Master.class) 
    public double getPrice(){
	 return delegate.getPrice();
    }
     
    public boolean getLimitedCapacity(){
	 return delegate.getLimitedCapacity();
    }

    public String getCapacityNarrative(){
	 return delegate.getCapacityNarrative();
    }
    
    public Location getLocation(){
	return delegate.getLocation();
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
	Activity other = (Activity) obj;
	if (delegate == null) {
	    if (other.delegate != null)
		return false;
	} else if (!delegate.equals(other.delegate))
	    return false;
	return true;
    }
    
}
