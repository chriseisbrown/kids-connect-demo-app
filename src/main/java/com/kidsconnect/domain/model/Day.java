package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;


public enum Day {
    SUNDAY  ("Sunday"),
    MONDAY ("Monday"),
    TUESDAY ("Tuesday"),
    WEDNESDAY ("Wednesday"),    
    THURSDAY ("Thursday"),
    FRIDAY ("Friday"),
    SATURDAY ("Saturday"); 
    
    private final String description;
    
    Day(String description){
	this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public static Day fromString(String value){
	return getEnumFromString(Day.class, value);
    }
}