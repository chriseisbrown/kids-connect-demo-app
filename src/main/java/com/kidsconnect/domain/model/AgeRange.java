package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;

public enum AgeRange {
    ANY("Any"),
    FROM18MONTHS("From 18 months"),
    YRS2ANDUNDER("Years 2 And under"),
    YRS5ANDUNDER("Years 5 And under"),
    YRS6ANDUNDER("Years 6 And under"),
    EXPECTANT_PARENTS("Expectant Parents");
    
    
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
