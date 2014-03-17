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

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.kidsconnect.domain.data.impl.PojoReviewData;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Review;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Location;


public class ReviewCSVFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewCSVFileReader.class);
    
   private Map<String, Review> reviewMap = new HashMap<String, Review>();    
    
    public ReviewCSVFileReader(){
	this.load();
    }
    
    public List<Review> data(){
	return new ArrayList<Review>(reviewMap.values());  
    }

    public int count(){
	return reviewMap.size();
    }
    
    public Review get(String id){
	return reviewMap.get(id);
    }
    
    private void load(){
	try {
	    DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
	    
	    ClassPathResource r = new ClassPathResource("reviews.csv");
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(r.getFile()), "UTF8"));

	    String str;
	    int rowCount = 0;

	    while ((str = in.readLine()) != null) {
		//System.out.println(str);
		if(rowCount !=0){
		    String[] fields = str.split(",");
		    // get fields from row, put in member variables
		    PojoReviewData p = new PojoReviewData(
			    fields[0],		//reviewId
			    fields[1],		//activityId
			    fields[2], 		//userName
			    fields[3], 		//userDisplayName
			    formatter.parseDateTime(fields[4]),  //datetime
			    fields[5],		//rating
			    fields[6]		//narrative
			    );		
		    
		    
		    reviewMap.put(p.reviewId, p.makeDomainWrapper());
		    
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

