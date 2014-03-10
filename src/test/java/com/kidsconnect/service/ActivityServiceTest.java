package com.kidsconnect.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.services.ActivityFinderData;
import com.kidsconnect.services.ActivityService;


public class ActivityServiceTest {
    
    private ActivityService serviceUnderTest;
    
    private List<Activity> actList;
  
    @Mock
    HttpServletRequest servletRequest;
    
    @Mock
    HttpSession session;  
    
    Map<String, String[]> parameterMap;
  
    
    @Before
    public void setUp(){
	initMocks(this);
	
	this.actList = ActivityFinderData.datafromCSV();
    }
 
    @SuppressWarnings("unchecked")
    @Test
    public void searchUsingSearchTerm(){
	
	Map<String, String[]> parameterMap = Maps.newHashMap();
	
	parameterMap.put(ActivityFinderData.Q, new String[]{"cooking"});
	parameterMap.put(ActivityFinderData.I, ActivityFinderData.NOT_RELEVANT);
	
	when(servletRequest.getSession(true)).thenReturn(session);
	when(servletRequest.getParameterMap()).thenReturn(parameterMap);
	
	ObjectMapper mapper = new ObjectMapper();
	
	this.serviceUnderTest = new ActivityService(mapper, new PojoActivityFinder(this.actList));
	
	Response response = this.serviceUnderTest.search(servletRequest, "cooking");
	    
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        Assert.assertThat(response.getEntity(), CoreMatchers.is(ResultSet.class));

        ResultSet<Activity> resultSet = (ResultSet<Activity>) response.getEntity();
        Assert.assertThat(resultSet.size(), CoreMatchers.is(2));
        Assert.assertTrue(resultSet.getResults().contains(ActivityFinderData.POJO_ACTIVITY_DATA_1040));
        Assert.assertTrue(resultSet.getResults().contains(ActivityFinderData.POJO_ACTIVITY_DATA_1038));
    }
    
    
    
    @SuppressWarnings("unchecked")
    @Test
    public void searchUsingCriteriaAndSearchTerm(){
	
	Map<String, String[]> parameterMap = Maps.newHashMap();
	parameterMap.put(ActivityFinderData.BOOK, ActivityFinderData.TRUE);
	parameterMap.put(ActivityFinderData.FREE, ActivityFinderData.TRUE);
	parameterMap.put(ActivityFinderData.DIST, ActivityFinderData.DISTANCE);
	
	parameterMap.put(ActivityFinderData.Q, ActivityFinderData.NOT_RELEVANT);
	parameterMap.put(ActivityFinderData.I, ActivityFinderData.NOT_RELEVANT);
	
	when(servletRequest.getSession(true)).thenReturn(session);
	when(servletRequest.getParameterMap()).thenReturn(parameterMap);
	
	ObjectMapper mapper = new ObjectMapper();
	
	this.serviceUnderTest = new ActivityService(mapper, new PojoActivityFinder(this.actList));
	
	Response response = this.serviceUnderTest.search(servletRequest, "cooking");
	    
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        Assert.assertThat(response.getEntity(), CoreMatchers.is(ResultSet.class));

        ResultSet<Activity> resultSet = (ResultSet<Activity>) response.getEntity();
        Assert.assertThat(resultSet.size(), CoreMatchers.is(1));
        Assert.assertTrue(resultSet.getResults().contains(ActivityFinderData.POJO_ACTIVITY_DATA_1040));
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void searchUsingCriteriaOnly(){
	
	Map<String, String[]> parameterMap = Maps.newHashMap();
	parameterMap.put(ActivityFinderData.BOOK, ActivityFinderData.TRUE);
	parameterMap.put(ActivityFinderData.FREE, ActivityFinderData.FALSE);
	parameterMap.put(ActivityFinderData.ACTIVITY, ActivityFinderData.ACTIVITY_MUSICANDDANCE);
	
	parameterMap.put(ActivityFinderData.DIST, ActivityFinderData.DISTANCE);
	
	parameterMap.put(ActivityFinderData.Q, ActivityFinderData.NOT_RELEVANT);
	parameterMap.put(ActivityFinderData.I, ActivityFinderData.NOT_RELEVANT);
	
	when(servletRequest.getSession(true)).thenReturn(session);
	when(servletRequest.getParameterMap()).thenReturn(parameterMap);
	
	ObjectMapper mapper = new ObjectMapper();
	
	this.serviceUnderTest = new ActivityService(mapper, new PojoActivityFinder(this.actList));
	
	Response response = this.serviceUnderTest.search(servletRequest, "{search-query}");
	    
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        Assert.assertThat(response.getEntity(), CoreMatchers.is(ResultSet.class));

        ResultSet<Activity> resultSet = (ResultSet<Activity>) response.getEntity();
        Assert.assertThat(resultSet.size(), CoreMatchers.is(1));
        Assert.assertTrue(resultSet.getResults().contains(ActivityFinderData.POJO_ACTIVITY_DATA_1019));
    }
}
