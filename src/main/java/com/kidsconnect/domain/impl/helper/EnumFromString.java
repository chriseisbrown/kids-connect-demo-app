package com.kidsconnect.domain.impl.helper;


public class EnumFromString {

    
    public static  <T extends Enum<T>> T getEnumFromString(Class<T> enumClass, String value) throws IllegalArgumentException{
	
	if(value !=null && !value.isEmpty()){
            return Enum.valueOf(enumClass, value);
	}
	
	return null;
    }
    
}
