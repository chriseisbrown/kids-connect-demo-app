package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;

public enum ActivityType {
    ANY,
    COOKING,
    STAYANDPLAY,
    COURSE,
    CLASS,
    WORKSHOP,
    CAFE,
    MUSICANDDANCE,
    DROPIN,
    PLAYGROUP,
    STORIES,
    DADS;
    
    public static ActivityType fromString(String value){
	return getEnumFromString(ActivityType.class, value);
    }
    
}
