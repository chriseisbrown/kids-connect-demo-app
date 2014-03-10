package com.kidsconnect.domain.impl.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kidsconnect.domain.model.ActivityType;

public class EnumFromStringTest {

    @Test
    public void testConversionOK() {
	assertEquals(ActivityType.CAFE, EnumFromString.getEnumFromString(ActivityType.class, "CAFE"));
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testConversionNotFound() {
	assertNull(EnumFromString.getEnumFromString(ActivityType.class, "BALONEY"));
    }

    
    @Test
    public void garbageInNullOut() {
	assertNull(EnumFromString.getEnumFromString(ActivityType.class, null));
    }
}
