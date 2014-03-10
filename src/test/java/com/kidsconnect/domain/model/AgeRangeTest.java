package com.kidsconnect.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


public class AgeRangeTest {

    @Test
    public void testConversionOK() {
	assertEquals(AgeRange.FROM18MONTHS, AgeRange.fromString("FROM18MONTHS"));
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testConversionNotFound() {
	assertNull(AgeRange.fromString("NOTVALID"));
    }

    
    @Test
    public void garbageInNullOut() {
	assertNull(null);
    }
}
