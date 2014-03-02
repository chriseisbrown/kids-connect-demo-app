package com.kidsconnect.domain.data.impl;

import com.kidsconnect.domain.data.ActivityData;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;


public class PojoActivityData implements ActivityData {

    public String activityId;
    public String name;
    public ActivityType type;
    public String description;
    public AgeRange age;
    
    public PojoActivityData(String id) {
	this.activityId = id;
	this.name = "";
    }

    public PojoActivityData(String id, String name, ActivityType type, String description) {
	this(id);
	this.name = name;
	this.type = type;
	this.description = description;
    }
    
    public PojoActivityData(String id, String name, ActivityType type,String description, AgeRange range) {
	this(id, name, type, description);
	this.age = range;
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

    @Override
    public Activity makeDomainWrapper() {
	return new Activity(this);
    }

    @Override
    public String toString() {
	return "PojoActivityData [activityId=" + activityId + ", name=" + name
		+ ", type=" + type + ", description=" + description + ", age="
		+ age + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((activityId == null) ? 0 : activityId.hashCode());
	result = prime * result + ((age == null) ? 0 : age.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (type != other.type)
	    return false;
	return true;
    }

    
}
