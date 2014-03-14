package com.kidsconnect.domain.impl.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CSVFileReaderTest {

    
    private ActivityCSVFileReader underTest = new ActivityCSVFileReader();
    
    @Test (timeout=50)
    public void testLoadedCorrectNumberofRows() {
	assertEquals(7, underTest.count());
    }

}
