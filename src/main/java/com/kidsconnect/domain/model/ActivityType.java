package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;

public enum ActivityType {
    ANY("Any"),
    COOKING("Cooking"),
    STAYANDPLAY("Stay and Play"),
    COURSE("Course"),
    CLASS("Class"),
    WORKSHOP("Workshop"),
    CAFE("Cafe"),
    MUSICANDDANCE("Music and dance"),
    DROPIN("Drop-in"),
    PLAYGROUP("Playgroup"),
    STORIES("Stories"),
    DADS("Dads");
    
    private final String description;
    
    ActivityType(String description){
	this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ActivityType fromString(String value){
	return getEnumFromString(ActivityType.class, value);
    }
    
}
