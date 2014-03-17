package com.kidsconnect.domain.data;

import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Link;
import com.kidsconnect.domain.model.Location;

public interface ActivityData {

    public String getName();
    public ActivityType getType();
    public String getId();
    public AgeRange getAgeRange();
    public String getDescription();
    public String getNarrative();
    public boolean getBookingRequired();
    public String getBookingNarrative();
    public boolean getFreeOfCharge();
    public double getPrice();
    public boolean getLimitedCapacity();
    public String getCapacityNarrative();
    
    public String getVenueId();
    public String getVenueName();  
    public Location getLocation();
    
    public Link getContactLink();
    public String getContactPhone();

    Activity makeDomainWrapper();
}
