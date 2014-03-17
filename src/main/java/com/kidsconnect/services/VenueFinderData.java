package com.kidsconnect.services;

import java.util.Arrays;
import java.util.List;

import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.impl.helper.ActivityCSVFileReader;
import com.kidsconnect.domain.impl.helper.VenueCSVFileReader;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Venue;

public class VenueFinderData {
    
    private static VenueCSVFileReader venueFileReader = new VenueCSVFileReader();

    public static Venue POJO_VENUE_DATA_7 = venueFileReader.get("7"); 
    public static Venue POJO_VENUE_DATA_8 = venueFileReader.get("8");
    public static Venue POJO_VENUE_DATA_9 = venueFileReader.get("9");
    public static Venue POJO_VENUE_DATA_10  = venueFileReader.get("10");
    public static Venue POJO_VENUE_DATA_101 = venueFileReader.get("101");
    public static Venue POJO_VENUE_DATA_102 = venueFileReader.get("102");
    public static Venue POJO_VENUE_DATA_103 = venueFileReader.get("103");
    public static Venue POJO_VENUE_DATA_104 = venueFileReader.get("104");
    
    
    
    public static List<Venue> data(){
    
	Venue v[] = new Venue[]{
		POJO_VENUE_DATA_7,
		POJO_VENUE_DATA_8,
		POJO_VENUE_DATA_9,
		POJO_VENUE_DATA_9,	// deliberate
		POJO_VENUE_DATA_10,
		POJO_VENUE_DATA_101,
		POJO_VENUE_DATA_102,
		POJO_VENUE_DATA_103,
		POJO_VENUE_DATA_104
		};
	return Arrays.asList(v);
    }
    
    
    public static List<Venue> datafromCSV(){
	return venueFileReader.data();
    }
}
