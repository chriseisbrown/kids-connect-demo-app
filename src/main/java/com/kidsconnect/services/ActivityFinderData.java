package com.kidsconnect.services;

import java.util.Arrays;
import java.util.List;

import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.impl.helper.ActivityCSVFileReader;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Location;

public class ActivityFinderData {

    public static final String Q = "q";
    public static final String I = "i";
    public static final String BOOK = "book";
    public static final String FREE = "free";
    public static final String ACTIVITY = "activity";
    public static final String AGE_RANGE = "agerange";
    public static final String DIST = "dist";

    public static final String[] TRUE = {"true"};
    public static final String[] FALSE = {"false"};
    public static final String[] NOT_RELEVANT = {"ignore this"};
    public static final String[] DISTANCE = {"0.5"};

    public static final String[] ACTIVITY_MUSICANDDANCE = {ActivityType.MUSICANDDANCE.toString()};

    
    private static ActivityCSVFileReader activityFileReader = new ActivityCSVFileReader();
    
    public static Activity POJO_ACTIVITY_DATA_1001 = activityFileReader.get("1001"); 
    public static Activity POJO_ACTIVITY_DATA_1010 = activityFileReader.get("1010"); 
    public static Activity POJO_ACTIVITY_DATA_1019 = activityFileReader.get("1019"); 
    public static Activity POJO_ACTIVITY_DATA_1038 = activityFileReader.get("1038"); 
    public static Activity POJO_ACTIVITY_DATA_1039 = activityFileReader.get("1039");
    public static Activity POJO_ACTIVITY_DATA_1040 = activityFileReader.get("1040"); 
    public static Activity POJO_ACTIVITY_DATA_1041 = activityFileReader.get("1041");
	    

    
    public static List<Activity> data(){
	
	Activity a[] = new Activity[]{
		POJO_ACTIVITY_DATA_1001,
		POJO_ACTIVITY_DATA_1010,
		POJO_ACTIVITY_DATA_1019,
		POJO_ACTIVITY_DATA_1038,
		POJO_ACTIVITY_DATA_1039,
		POJO_ACTIVITY_DATA_1040,
		POJO_ACTIVITY_DATA_1041};
	return Arrays.asList(a);
    }
  
    
    public static List<Activity> datafromCSV(){
	return activityFileReader.data();
    }

}
