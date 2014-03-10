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

import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;

public class CSVFileReader {

    private List<Activity> activityList = new ArrayList<Activity>();   
    private Map<Integer, Activity> playerMap;    
    
    public CSVFileReader(){
	this.load();
    }
    
    public List<Activity> data(){
	return activityList;
    }

    public int count(){
	return activityList.size();
    }
    
    private void load(){
	try {
		File fileDir = new File("src/main/resources/activities.csv");
 
		BufferedReader in = new BufferedReader(new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));
 
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
    		    		Double.parseDouble(fields[10]),				//price
    		    		Boolean.parseBoolean(fields[11]),			//limited cap
    		    		fields[12]);		//cap narrative
    		    	
    		    	activityList.add(p.makeDomainWrapper());
    		    	System.out.println(p);
		    }	
		    rowCount++;
		}
 
                in.close();
	} 
	catch(UnsupportedEncodingException e) 
	{
	    System.out.println(e.getMessage());
	} 
	catch(IOException e) 
	{
	    System.out.println(e.getMessage());
	}
	catch(Exception e)
	{
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}
    }
    
}

