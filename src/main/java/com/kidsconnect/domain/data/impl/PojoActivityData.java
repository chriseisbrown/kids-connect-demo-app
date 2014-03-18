package com.kidsconnect.domain.data.impl;

import org.joda.time.LocalTime;

import com.kidsconnect.domain.data.ActivityData;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Day;
import com.kidsconnect.domain.model.Link;
import com.kidsconnect.domain.model.Location;


public class PojoActivityData implements ActivityData {

    public String activityId = "";
    public String name = "";
    public ActivityType type;
    public String description = "";
    public String narrative = "";
    public AgeRange age;
    
    public boolean bookingRequired = false;
    public String bookingNarrative = "";
    public boolean freeOfCharge = true;
    public double price = 0.0;
    public boolean limitedCapacity = false;
    public String capacityNarrative = "";
    
    public String venueId = "";
    public String venueName = "";
    public Location location;
    
    public Link contactLink;
    public String contactPhone;
    
    public Day day;
    public LocalTime start;
    public LocalTime end;
    
    
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
	    		    String capacityNarrative, Location location, String descNarrative,
	    		    Link contactLink, String contactPhone, Day day, LocalTime start, LocalTime end) {
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
	this.location = location;
	this.narrative = descNarrative;
	this.contactLink = contactLink;
	this.contactPhone = contactPhone;
	this.day = day;
	this.start = start;
	this.end = end;
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
    
    public String getNarrative() {
        return narrative;
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

    public Location getLocation() {
        return location;
    }
    
    @Override
    public Link getContactLink() {
	return contactLink;
    }

    @Override
    public String getContactPhone() {
	return contactPhone;
    }
    
    public Day getDay() {
        return day;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public Activity makeDomainWrapper() {
	return new Activity(this);
    }

    @Override
    public String toString() {
	return "PojoActivityData [activityId=" + activityId + ", name=" + name
		+ ", type=" + type + ", description=" + description
		+ ", narrative=" + narrative + ", age=" + age
		+ ", bookingRequired=" + bookingRequired
		+ ", bookingNarrative=" + bookingNarrative + ", freeOfCharge="
		+ freeOfCharge + ", price=" + price + ", limitedCapacity="
		+ limitedCapacity + ", capacityNarrative=" + capacityNarrative
		+ ", venueId=" + venueId + ", venueName=" + venueName
		+ ", location=" + location + ", contactLink=" + contactLink
		+ ", contactPhone=" + contactPhone + ", day=" + day
		+ ", start=" + start + ", end=" + end + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((activityId == null) ? 0 : activityId.hashCode());
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
	return true;
    }





    
}
