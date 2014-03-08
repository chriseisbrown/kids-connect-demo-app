package com.kidsconnect.domain.data.impl;

import com.kidsconnect.domain.data.ActivityData;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;


public class PojoActivityData implements ActivityData {

    public String activityId = "";
    public String name = "";
    public ActivityType type;
    public String description = "";
    public AgeRange age;
    
    public boolean bookingRequired;
    public String bookingNarrative = "";
    public boolean freeOfCharge = false;
    public double price = 0.0;
    public boolean limitedCapacity = false;
    public String capacityNarrative = "";
    
    public String venueId = "";
    public String venueName = "";
    
    
    public PojoActivityData(String id) {
	this.activityId = id;
    }

    public PojoActivityData(String id, String name, ActivityType type, String description) {
	this(id);
	this.name = name;
	this.type = type;
	this.description = description;
    }
    
    public PojoActivityData(String id, String name, ActivityType type,String description, AgeRange range, String venueId, String venueName) {
	this(id, name, type, description);
	this.age = range;
	this.venueId = venueId;
	this.venueName = venueName;
    }

    public PojoActivityData(String id, String name, ActivityType type,String description, AgeRange range, String venueId, String venueName,
	    		    boolean bookingRequired, String bookingNarrative, boolean freeOfCharge, double price, boolean limitedCapacity,
	    		    String capacityNarrative) {
	this(id, name, type, description);
	this.age = range;
	this.venueId = venueId;
	this.venueName = venueName;
	this.bookingRequired = bookingRequired;
	this.bookingNarrative = bookingNarrative;
	this.freeOfCharge = freeOfCharge;
	this.price = price;
	this.limitedCapacity = limitedCapacity;
	this.capacityNarrative = capacityNarrative;
    }
    
    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getId() {
	return activityId;
    }
    
    public ActivityType getType() {
        return type;
    }
    
    public AgeRange getAgeRange() {
        return age;
    }

    public String getDescription() {
        return description;
    }
    
    public String getVenueId() {
 	return venueId;
    } 
    
    public String getVenueName() {
 	return venueName;
    }
    
    public String getActivityId() {
        return activityId;
    }

    public AgeRange getAge() {
        return age;
    }

    public boolean getBookingRequired() {
        return bookingRequired;
    }

    public String getBookingNarrative() {
        return bookingNarrative;
    }

    public boolean getFreeOfCharge() {
        return freeOfCharge;
    }

    public double getPrice() {
        return price;
    }

    public boolean getLimitedCapacity() {
        return limitedCapacity;
    }

    public String getCapacityNarrative() {
        return capacityNarrative;
    }

    @Override
    public Activity makeDomainWrapper() {
	return new Activity(this);
    }

    @Override
    public String toString() {
	return "PojoActivityData [activityId=" + activityId + ", name=" + name
		+ ", type=" + type + ", description=" + description + ", age="
		+ age + ", bookingRequired=" + bookingRequired
		+ ", bookingNarrative=" + bookingNarrative + ", freeOfCharge="
		+ freeOfCharge + ", price=" + price + ", limitedCapacity="
		+ limitedCapacity + ", capacityNarrative=" + capacityNarrative
		+ ", venueId=" + venueId + ", venueName=" + venueName + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((activityId == null) ? 0 : activityId.hashCode());
	result = prime * result + ((age == null) ? 0 : age.hashCode());
	result = prime
		* result
		+ ((bookingNarrative == null) ? 0 : bookingNarrative.hashCode());
	result = prime * result + (bookingRequired ? 1231 : 1237);
	result = prime
		* result
		+ ((capacityNarrative == null) ? 0 : capacityNarrative
			.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + (freeOfCharge ? 1231 : 1237);
	result = prime * result + (limitedCapacity ? 1231 : 1237);
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((venueId == null) ? 0 : venueId.hashCode());
	result = prime * result
		+ ((venueName == null) ? 0 : venueName.hashCode());
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
	PojoActivityData other = (PojoActivityData) obj;
	if (activityId == null) {
	    if (other.activityId != null)
		return false;
	} else if (!activityId.equals(other.activityId))
	    return false;
	if (age != other.age)
	    return false;
	if (bookingNarrative == null) {
	    if (other.bookingNarrative != null)
		return false;
	} else if (!bookingNarrative.equals(other.bookingNarrative))
	    return false;
	if (bookingRequired != other.bookingRequired)
	    return false;
	if (capacityNarrative == null) {
	    if (other.capacityNarrative != null)
		return false;
	} else if (!capacityNarrative.equals(other.capacityNarrative))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (freeOfCharge != other.freeOfCharge)
	    return false;
	if (limitedCapacity != other.limitedCapacity)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (Double.doubleToLongBits(price) != Double
		.doubleToLongBits(other.price))
	    return false;
	if (type != other.type)
	    return false;
	if (venueId == null) {
	    if (other.venueId != null)
		return false;
	} else if (!venueId.equals(other.venueId))
	    return false;
	if (venueName == null) {
	    if (other.venueName != null)
		return false;
	} else if (!venueName.equals(other.venueName))
	    return false;
	return true;
    }



    
}
