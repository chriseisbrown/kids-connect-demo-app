package com.kidsconnect.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


public class ActivityTypeTest {

    @Test
    public void testConversionOK() {
	assertEquals(ActivityType.CAFE, ActivityType.fromString("CAFE"));
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testConversionNotFound() {
	assertNull(ActivityType.fromString("BALONEY"));
    }

    
    @Test
    public void garbageInNullOut() {
	assertNull(null);
    }
}
