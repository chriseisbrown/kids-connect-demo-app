package com.kidsconnect.domain.model;

import com.kidsconnect.domain.data.ActivityData;


public class Activity implements DomainClass
{
    private ActivityData delegate;
    
    public Activity(ActivityData delegate)
    {
	this.delegate = delegate;
    }  

    public String getName(){
	return delegate.getName();
    }
    
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
     
    public double getPrice(){
	 return delegate.getPrice();
    }
     
    public boolean getLimitedCapacity(){
	 return delegate.getLimitedCapacity();
    }

    public String getCapacityNarrative(){
	 return delegate.getCapacityNarrative();
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
