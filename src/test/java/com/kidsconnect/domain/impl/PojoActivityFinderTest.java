package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.CriteriaChain;
import com.kidsconnect.domain.model.ParameterCriteria;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.ResultSizeCriteria;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.services.ActivityFinderData;



public class PojoActivityFinderTest {

    static List<Activity> activityList;
 
    
    @BeforeClass
    public static void setUp()
    {
	activityList = ActivityFinderData.data();
    }
    
    @Test
    public void dontfindOneNotInList() {

	final String id = "77";
	Activity activity = new PojoActivityFinder(PojoActivityFinderTest.activityList).findOne(id);
	assertNull(activity);
    }

    @Test
    public void findOneInList() {

	final String id = "1038";
	Activity activity = new PojoActivityFinder(PojoActivityFinderTest.activityList).findOne(id);
	System.out.println(activity);
	assertEquals(id, activity.getId());
	assertEquals(ActivityFinderData.POJO_ACTIVITY_DATA_1038, activity);
    }
    
    @Test
    public void findAll() {
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findAll();
	assertEquals(activities.size(), activityList.size());
    }

    @Test
    public void findMany() {
	
	QueryCriteria<Activity> criteria = new QueryCriteria<Activity>(new String("stay"));
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(criteria);
	assertEquals(4, activities.size());
    }
    
    
    @Test
    public void findByVenue() {
	
	String venueId = "103";
	
	List<Activity> expectedActivitiesList = Arrays.asList(new Activity[]{	
	            ActivityFinderData.POJO_ACTIVITY_DATA_1010,
	            ActivityFinderData.POJO_ACTIVITY_DATA_1038});
	
	ResultSet<Activity> activitiesForVenue = new PojoActivityFinder(PojoActivityFinderTest.activityList).findByVenue(venueId);
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
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(chain);
	assertEquals(expectedResultSize, activities.size());
    }

    
    @Test
    public void findManyIsCaseInsensitive() {

	QueryCriteria<Activity> criteriaUpper = new QueryCriteria<Activity>(new String("diddi"));
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(criteriaUpper);
	assertEquals(1, activities.size());
	
	ImmutableList<Activity> results = activities.getResults();
	
	if(activities.size() == 1){
	    for (Activity activity : results){
		assertEquals(ActivityFinderData.POJO_ACTIVITY_DATA_1019, activity);
	    }
	}
	
	QueryCriteria<Activity> criteriaLower = new QueryCriteria<Activity>(new String("Diddi"));
	ResultSet<Activity> otherActivities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(criteriaLower);
	assertEquals(1, otherActivities.size());
	
	ImmutableList<Activity> otherResults = otherActivities.getResults();
	
	if(otherActivities.size() == 1){
	    for (Activity activity : otherResults){
		assertEquals(ActivityFinderData.POJO_ACTIVITY_DATA_1019, activity);
	    }
	}
    }
    
    
    @Test
    public void findManyIsASearchAcrossAttributesOfAnActivity() {
	
	List<Activity> expectedActivitiesList = Arrays.asList(new Activity[]{	
	               ActivityFinderData.POJO_ACTIVITY_DATA_1038,
	               ActivityFinderData.POJO_ACTIVITY_DATA_1040
	});

	QueryCriteria<Activity> criteria = new QueryCriteria<Activity>(new String("cooking"));
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(criteria);
	assertEquals(expectedActivitiesList.size(), activities.size());
	
	ImmutableList<Activity> results = activities.getResults();
	
	for (Activity activity : expectedActivitiesList){
	    assertTrue(results.contains(activity));
	}
	
    }
    
    @Test
    public void findManyWithNoQueryParameterSetGivesBackAllElements() {
	
	// if no query parameter is received then only a resultSize criteria will be passed in
	// and result will be all elements in the collection up to that size
	int resultSize = 25;
	ResultSizeCriteria<Activity> result = new ResultSizeCriteria<Activity>(resultSize);
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(result);
	assertEquals(PojoActivityFinderTest.activityList.size(), activities.size());
    }
    
    @Test
    public void findManyWithNoQueryParameterSetAndResultsSizeSetGivesBackResultSizeElements() {
	
	// expect to limit the amount of results coming back
	int resultSize = 2;
	ResultSizeCriteria<Activity> result = new ResultSizeCriteria<Activity>(resultSize);
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(result);
	assertEquals(2, activities.size());
    }
    
    
    @Test
    public void findManyWithQueryAndParameters() {
	
	List<Activity> expectedActivitiesList = Arrays.asList(new Activity[]{ActivityFinderData.POJO_ACTIVITY_DATA_1040});
	
	// expect to limit the amount of results coming back
	int resultSize = 20;
	ResultSizeCriteria<Activity> resultSizeCriteria = new ResultSizeCriteria<Activity>(resultSize);
	
	QueryCriteria<Activity> queryCriteria = new QueryCriteria<Activity>(new String("cooking"));
	
	Map<String, String[]> parameters = Maps.newHashMap();
	parameters.put(ActivityFinderData.BOOK, ActivityFinderData.TRUE);
	parameters.put(ActivityFinderData.FREE, ActivityFinderData.TRUE);
	parameters.put(ActivityFinderData.DIST, ActivityFinderData.DISTANCE);
	parameters.put(ActivityFinderData.Q, ActivityFinderData.NOT_RELEVANT);
	parameters.put(ActivityFinderData.I, ActivityFinderData.NOT_RELEVANT);
	
	ParameterCriteria<Activity> parameterCriteria = new ParameterCriteria<Activity>(parameters);

	CriteriaChain<Activity> chain1 = queryCriteria.attach(resultSizeCriteria);
	CriteriaChain<Activity> chain2 = chain1.attach(parameterCriteria);
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(chain2);
	
	assertEquals(expectedActivitiesList.size(), activities.size());
	
	ImmutableList<Activity> results = activities.getResults();
	assertTrue(results.contains(ActivityFinderData.POJO_ACTIVITY_DATA_1040));
    }
    
    @Test
    public void findManyWithNoQueryAndParameters() {

	List<Activity> expectedActivitiesList = Arrays.asList(new Activity[]{ActivityFinderData.POJO_ACTIVITY_DATA_1019});
	
	// expect to limit the amount of results coming back
	int resultSize = 20;
	ResultSizeCriteria<Activity> resultSizeCriteria = new ResultSizeCriteria<Activity>(resultSize);
		
	Map<String, String[]> parameters = Maps.newHashMap();
	parameters.put(ActivityFinderData.BOOK, ActivityFinderData.TRUE);
	parameters.put(ActivityFinderData.FREE, ActivityFinderData.FALSE);
	parameters.put(ActivityFinderData.DIST, ActivityFinderData.DISTANCE);
	parameters.put(ActivityFinderData.Q, ActivityFinderData.NOT_RELEVANT);
	parameters.put(ActivityFinderData.I, ActivityFinderData.NOT_RELEVANT);
	
	ParameterCriteria<Activity> parameterCriteria = new ParameterCriteria<Activity>(parameters);

	CriteriaChain<Activity> chain1 = parameterCriteria.attach(resultSizeCriteria);
	
	ResultSet<Activity> activities = new PojoActivityFinder(PojoActivityFinderTest.activityList).findMany(chain1);
	
	assertEquals(expectedActivitiesList.size(), activities.size());
	
	ImmutableList<Activity> results = activities.getResults();
	assertTrue(results.contains(ActivityFinderData.POJO_ACTIVITY_DATA_1019));
    }
    
}
