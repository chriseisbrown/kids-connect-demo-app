package com.kidsconnect.domain.impl.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Location;


public class VenueCSVFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(VenueCSVFileReader.class);
    
   private Map<String, Venue> venueMap = new HashMap<String, Venue>();    
    
    public VenueCSVFileReader(){
	this.load();
    }
    
    public List<Venue> data(){
	return new ArrayList<Venue>(venueMap.values());  
    }

    public int count(){
	return venueMap.size();
    }
    
    public Venue get(String id){
	return venueMap.get(id);
    }
    
    private void load(){
	try {
	    
	    ClassPathResource r = new ClassPathResource("venues.csv");
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(r.getFile()), "UTF8"));

	    String str;
	    int rowCount = 0;

	    while ((str = in.readLine()) != null) {
		System.out.println(str);
		if(rowCount !=0){
		    String[] fields = str.split(",");
		    // get fields from row, put in member variables
		    PojoVenueData p = new PojoVenueData(
			    fields[0],		//id
			    fields[1],		//name
			    fields[2], 		//address
			    new Borough(fields[3]),		//borough
			    new PostCode(fields[4]),	//postcode
			    new Location(Double.parseDouble(fields[5]), Double.parseDouble(fields[6])),  //lat, long
			    fields[7],		//transport
			    fields[8],		//access
		            Boolean.parseBoolean(fields[9]),    // babyChange;
			    Boolean.parseBoolean(fields[10]),    // liftAccess;	
		            Boolean.parseBoolean(fields[11]),    // buggyParking;	
		            Boolean.parseBoolean(fields[12]),    // breastFeeding;	
		            Boolean.parseBoolean(fields[13]),    // bottleWarming;	
		            Boolean.parseBoolean(fields[14]),    // vendingMachine;	
		            Boolean.parseBoolean(fields[15]),    // stepFree;
		            Boolean.parseBoolean(fields[16])   // refreshments;
			    );		
		    
		    venueMap.put(p.venueId, p.makeDomainWrapper());
		    
		    LOG.info(p.toString());
		 
		}	
		rowCount++;
	    }
	    
	    LOG.info("Succesfully loaded " + (rowCount - 1) + " entries");
	    in.close();
	} 
	catch(UnsupportedEncodingException e) 
	{
	    LOG.error(e.getMessage());
	} 
	catch(IOException e) 
	{
	    LOG.error(e.getMessage());
	}
	catch(Exception e)
	{
	    LOG.error(e.getMessage());
	    e.printStackTrace();

	}
    }
    
}

