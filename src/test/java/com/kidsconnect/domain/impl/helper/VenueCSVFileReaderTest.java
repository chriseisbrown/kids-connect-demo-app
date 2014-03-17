package com.kidsconnect.domain.impl.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class VenueCSVFileReaderTest {

    
    private VenueCSVFileReader underTest = new VenueCSVFileReader();
    
    @Test (timeout=50)
    public void testLoadedCorrectNumberofRows() {
	assertEquals(10, underTest.count());
    }

}
