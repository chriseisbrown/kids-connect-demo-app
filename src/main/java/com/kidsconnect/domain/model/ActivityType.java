package com.kidsconnect.domain.model;

import static com.kidsconnect.domain.impl.helper.EnumFromString.getEnumFromString;

public enum ActivityType {

    COOKING,
    STAYANDPLAY,
    COURSE,
    CLASS,
    WORKSHOP,
    CAFE,
    MUSICANDDANCE,
    DROPIN,
    PLAYGROUP,
    DADS;
    
    public static ActivityType fromString(String value){
	return getEnumFromString(ActivityType.class, value);
    }
    
}
