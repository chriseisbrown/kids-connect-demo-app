package com.kidsconnect.domain.impl.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ReviewCSVFileReaderTest {

    
    private ReviewCSVFileReader underTest = new ReviewCSVFileReader();
    
    @Test (timeout=50)
    public void testLoadedCorrectNumberofRows() {
	assertEquals(3, underTest.count());
    }

}
