package com.kidsconnect.services;

import java.util.Arrays;
import java.util.List;

import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.impl.helper.CSVFileReader;
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

    
    private static CSVFileReader activityFileReader = new CSVFileReader();
    
    
    
    public static Activity POJO_ACTIVITY_DATA_1001 = new PojoActivityData("1001", "Holiday stay and play sessions", ActivityType.STAYANDPLAY,
		    "Easter fun activities for all children.", AgeRange.YRS5ANDUNDER, "102", "Albrighton Community Centre").makeDomainWrapper();

    public static Activity POJO_ACTIVITY_DATA_1010 = new PojoActivityData("1010", "Stay and play for babies and toddlers", ActivityType.STAYANDPLAY, 
        "A session for both babies and toddlers to play.", AgeRange.YRS5ANDUNDER,
        "103", "Bessemer Grange Children\'s Centre").makeDomainWrapper();
        
    public static Activity POJO_ACTIVITY_DATA_1019 = new PojoActivityData("1019", "Diddi dance", ActivityType.MUSICANDDANCE, 
		"Music and movement sessions. Term time only.", AgeRange.FROM18MONTHS,
		"101", "The Grove Children and Family Centre",
		true, "Book in advance.", false, 6.50, false, "Unlimited places available", new Location(0,0)).makeDomainWrapper();

    public static Activity POJO_ACTIVITY_DATA_1038 = 
	    new PojoActivityData("1038", "Healthy fun time cooking", ActivityType.COOKING, 
                "After school stay and play with a focus on cooking fun for kids.", AgeRange.YRS6ANDUNDER,
                "103", "Bessemer Grange Children\'s Centre").makeDomainWrapper();

    public static Activity POJO_ACTIVITY_DATA_1039 = 
	    new PojoActivityData("1039", "Tuesday Stay \'n\' Play", ActivityType.STAYANDPLAY, 
		    "For parents and carers with children aged 0 to 5 years. These sessions are an opportunity for children to play in a fun and " +
			    "relaxed environment whilst giving parents and carers the opportunity to understand and gain knowledge of children\'s play.", AgeRange.YRS6ANDUNDER,
			    "104", "Coin Street family and children's centre (Borough)",
			    false, "Just turn up", true, 0.0, true, "Capacity is limited to 20", new Location(0,0)).makeDomainWrapper();
    
    public static Activity POJO_ACTIVITY_DATA_1040 = 
	    	new PojoActivityData("1040", "Sharing Stories session", ActivityType.PLAYGROUP, 
	    	    "Share and enjoy stories in a playful way, learn new skills to engage children in " +
	    	    "reading, making props for books, playing and exploring in messy play and cooking activities.", AgeRange.YRS6ANDUNDER,
		    "104", "Coin Street family and children's centre (Borough)",
		    true, "By referral only by a health visitor", true, 0.0, true, "By referral only by a health visitor", new Location(0,0)).makeDomainWrapper();

    public static Activity POJO_ACTIVITY_DATA_1041 = 
	    new PojoActivityData("1041", "Bumps and babies", ActivityType.PLAYGROUP, 
		    "This is a dedicated session for expectant parents and parents of children under two years old, focusing " +
			    "on exploration, investigation and activities to stimulate the minds of young children. Please note we have a " +
			    "maximum capacity for these sessions and if we are full you may be asked to come back another week.", AgeRange.YRS2ANDUNDER,
			    "104", "Coin Street family and children's centre (Borough)",
			    false, "Just turn up", true, 0.0, true, "max capacity applies", new Location(0,0)).makeDomainWrapper();

    
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
