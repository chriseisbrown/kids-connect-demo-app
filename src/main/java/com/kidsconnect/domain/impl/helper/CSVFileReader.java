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

import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Location;


public class CSVFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(CSVFileReader.class);
    
    private List<Activity> activityList = new ArrayList<Activity>();   
    private Map<String, Activity> activityMap;    
    
    public CSVFileReader(){
	this.load();
    }
    
    public List<Activity> data(){
	return activityList;
    }

    public int count(){
	return activityList.size();
    }
    
    public Activity get(String key){
	return activityMap.get(key);
    }
    
    private void load(){
	try {
	    
	    ClassPathResource r = new ClassPathResource("activities.csv");
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new FileInputStream(r.getFile()), "UTF8"));

	    String str;
	    int rowCount = 0;

	    while ((str = in.readLine()) != null) {
		//System.out.println(str);
		if(rowCount !=0){
		    String[] fields = str.split(",");
		    // get fields from row, put in member variables
		    PojoActivityData p = new PojoActivityData(
			    fields[0],		//id
			    fields[1],		//name
			    ActivityType.fromString(fields[2]), //type
			    fields[3],		//desc
			    AgeRange.fromString(fields[4]),	//age range
			    fields[5],		//venue id
			    fields[6],		//venue name
			    Boolean.parseBoolean(fields[7]),			//booking
			    fields[8],		//booking narrative
			    Boolean.parseBoolean(fields[9]),			//free
			    Double.parseDouble(fields[10]),			//price
			    Boolean.parseBoolean(fields[11]),			//limited cap
			    fields[12],						//cap narrative
			    new Location(Double.parseDouble(fields[13]), Double.parseDouble(fields[14]))		//lat, long
			    );		

		    activityList.add(p.makeDomainWrapper());
		    
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

