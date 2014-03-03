package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.CriteriaChain;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.ResultSizeCriteria;
import com.kidsconnect.domain.model.Activity;



public class PojoActivityFinderTest {

    static List<Activity> activityList;
    
    
    @BeforeClass
    public static void setUp()
    {
	Activity a[] = new Activity[]{
		new PojoActivityData("1001", "Holiday stay and play sessions", ActivityType.STAYANDPLAY,
		    "Easter fun activities for all children.", AgeRange.YRS8ANDUNDER, "102").makeDomainWrapper(),
		new PojoActivityData("1010", "Stay and play for babies and toddlers", ActivityType.STAYANDPLAY, 
	            "A session for both babies and toddlers to play.", AgeRange.YRS5ANDUNDER, "103").makeDomainWrapper(),
	        new PojoActivityData("1019", "Diddi dance", ActivityType.MUSICANDDANCE, 
	        	    "Music and movement sessions. Term time only.", AgeRange.FROM18MONTHS, "101").makeDomainWrapper(),
	        new PojoActivityData("1038", "Healthy fun time cooking", ActivityType.COOKING, 
	               "After school stay and play with a focus on cooking fun for kids.", AgeRange.YRS6ANDUNDER, "103").makeDomainWrapper()};

	activityList = Arrays.asList(a);
    }
    
    @Test
    public void dontfindOneNotInList() {

	final String id = "77";
	Activity activity = new PojoActivityFinder(this.activityList).findOne(id);
	assertNull(activity);
    }

    @Test
    public void findOneInList() {

	final String id = "1038";
	Activity activity = new PojoActivityFinder(this.activityList).findOne(id);
	System.out.println(activity);
	assertEquals(activity.getId(), id);
    }
    
    @Test
    public void findAll() {
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findAll();
	assertEquals(activities.size(), activityList.size());
    }

    @Test
    public void findMany() {
	
	QueryCriteria<Activity> criteria = new QueryCriteria<Activity>(new String("stay"));
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findMany(criteria);
	assertEquals(3, activities.size());
    }
    
    @Test
    public void findByVenue() {
	
	String venueId = "103";
	
	Activity expectedActivities[] = new Activity[]{	
		new PojoActivityData("1010", "Stay and play for babies and toddlers", ActivityType.STAYANDPLAY, 
	            "A session for both babies and toddlers to play.", AgeRange.YRS5ANDUNDER, "103").makeDomainWrapper(),
	        new PojoActivityData("1038", "Healthy fun time cooking", ActivityType.COOKING, 
	     	    "After school stay and play with a focus on cooking fun for kids.", AgeRange.YRS6ANDUNDER, "103").makeDomainWrapper()};

	List<Activity> expectedActivitiesList = Arrays.asList(expectedActivities);
	
	ResultSet<Activity> activitiesForVenue = new PojoActivityFinder(this.activityList).findByVenue(venueId);
	assertEquals(expectedActivitiesList.size(), activitiesForVenue.size());
	
	ImmutableList<Activity> results = activitiesForVenue.getResults();
	
	for (Activity activity : expectedActivitiesList){
	    assertTrue(results.contains(activity));
	}
    }
    
    @Test
    public void findManyWithResultsSizeSetReturnsCorrectAmountOfResults() {
	
	int expectedResultSize = 1;
	ResultSizeCriteria<Activity> resultSizeCriteria = new ResultSizeCriteria<Activity>(expectedResultSize);
	QueryCriteria<Activity> criteria = new QueryCriteria<Activity>(new String("stay"));
	CriteriaChain<Activity> chain = criteria.attach(resultSizeCriteria);
	
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findMany(chain);
	assertEquals(expectedResultSize, activities.size());
    }

    @Test
    public void findManyIsCaseInsensitive() {

	Activity a = new PojoActivityData("1019", "Diddi dance", ActivityType.MUSICANDDANCE, 
			"Music and movement sessions. Term time only.", AgeRange.FROM18MONTHS, "101").makeDomainWrapper();

	QueryCriteria<Activity> criteriaUpper = new QueryCriteria<Activity>(new String("diddi"));
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findMany(criteriaUpper);
	assertEquals(1, activities.size());
	
	ImmutableList<Activity> results = activities.getResults();
	
	if(activities.size() == 1){
	    for (Activity activity : results){
		assertEquals(a, activity);
	    }
	}
	
	QueryCriteria<Activity> criteriaLower = new QueryCriteria<Activity>(new String("Diddi"));
	ResultSet<Activity> otherActivities = new PojoActivityFinder(this.activityList).findMany(criteriaLower);
	assertEquals(1, otherActivities.size());
	
	ImmutableList<Activity> otherResults = otherActivities.getResults();
	
	if(otherActivities.size() == 1){
	    for (Activity activity : otherResults){
		assertEquals(a, activity);
	    }
	}
    }
    
    
    @Test
    public void findManyIsASearchAcrossAttributesOfAnActivity() {

	
	Activity expectedActivities[] = new Activity[]{	
		new PojoActivityData("1001", "Holiday stay and play sessions", ActivityType.STAYANDPLAY,
		    "Easter fun activities for all children.", AgeRange.YRS8ANDUNDER, "102").makeDomainWrapper(),
		new PojoActivityData("1010", "Stay and play for babies and toddlers", ActivityType.STAYANDPLAY, 
	            "A session for both babies and toddlers to play.", AgeRange.YRS5ANDUNDER, "103").makeDomainWrapper(),
	        new PojoActivityData("1019", "Diddi dance", ActivityType.MUSICANDDANCE, 
	        	    "Music and movement sessions. Term time only.", AgeRange.FROM18MONTHS, "101").makeDomainWrapper()};

	List<Activity> expectedActivitiesList = Arrays.asList(expectedActivities);

	QueryCriteria<Activity> criteria = new QueryCriteria<Activity>(new String("session"));
	
	ResultSet<Activity> otherActivities = new PojoActivityFinder(this.activityList).findMany(criteria);
	assertEquals(expectedActivitiesList.size(), otherActivities.size());
	
	ImmutableList<Activity> results = otherActivities.getResults();
	
	for (Activity activity : expectedActivitiesList){
	    assertTrue(results.contains(activity));
	}
	
    }
    
    @Test
    public void findManyWithNoQueryParameterSetGivesBackAllElements() {
	
	// if no query parameter is received then only a resultSize criteria will be passed in
	// and result will be all elements in the collection
	int resultSize = 25;
	ResultSizeCriteria<Activity> result = new ResultSizeCriteria<Activity>(resultSize);
	
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findMany(result);
	assertEquals(this.activityList.size(), activities.size());
    }
    
    @Test
    public void findManyWithNoQueryParameterSetAndResultsSizeSetGivesBackResultSizeElements() {
	
	// expect to limit the amount of results coming back
	int resultSize = 2;
	ResultSizeCriteria<Activity> result = new ResultSizeCriteria<Activity>(resultSize);
	
	ResultSet<Activity> activities = new PojoActivityFinder(this.activityList).findMany(result);
	assertEquals(2, activities.size());
    }
    
}
