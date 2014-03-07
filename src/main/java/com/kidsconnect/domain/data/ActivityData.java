package com.kidsconnect.domain.data;

import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;

public interface ActivityData {

    public String getName();
    public ActivityType getType();
    public String getId();
    public AgeRange getAgeRange();
    public String getDescription();
    public boolean getBookingRequired();
    public String getBookingNarrative();
    public boolean getFreeOfCharge();
    public double getPrice();
    public boolean getLimitedCapacity();
    public String getCapacityNarrative();
    
    public String getVenueId();
    public String getVenueName();    

    Activity makeDomainWrapper();
}
