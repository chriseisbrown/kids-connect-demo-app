package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;

public enum AgeRange {
    ANY("Any"),
    FROM18MONTHS("From 18 months"),
    YRS2ANDUNDER("2 and under"),
    YRS5ANDUNDER("5 and under"),
    YRS6ANDUNDER("6 and under"),
    EXPECTANT_PARENTS("Expectant parents");
    
    
    private final String description;
    
    AgeRange(String description){
	this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public static AgeRange fromString(String value){
	return getEnumFromString(AgeRange.class, value);
    }
    
}
