package com.kidsconnect.domain.model;

public enum AgeRange {

    FROM18MONTHS("From 18 months"),
    YRS5ANDUNDER("Years 5 And under"),
    YRS6ANDUNDER("Years 6 And under"),
    YRS8ANDUNDER("Years 8 And under");
    
    
    private final String description;
    
    AgeRange(String description){
	this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
