package com.kidsconnect.domain.model;

public enum AgeRange {

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
    
    
    
}
