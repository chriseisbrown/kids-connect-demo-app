package com.kidsconnect.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.services.ActivityFinderData;
import com.kidsconnect.services.ActivityService;


public class ActivityServiceTest {
    
    private ActivityService serviceUnderTest;
    
    List<Activity> actList;
  
    @Mock
    HttpServletRequest servletRequest;
    
    @Mock
    HttpSession session;    
  
    
    @Before
    public void setUp(){
	initMocks(this);
	
	this.actList = ActivityFinderData.data();
    }
 
    
    @SuppressWarnings("unchecked")
    @Test
    public void search(){
	
	when(servletRequest.getSession(true)).thenReturn(session);
	
	ObjectMapper mapper = new ObjectMapper();
	
	this.serviceUnderTest = new ActivityService(mapper, new PojoActivityFinder(this.actList));
	
	Response response = this.serviceUnderTest.search(servletRequest, "cooking");
	    
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        Assert.assertThat(response.getEntity(), CoreMatchers.is(ResultSet.class));

        ResultSet<Venue> resultSet = (ResultSet<Venue>) response.getEntity();
        Assert.assertThat(resultSet.size(), CoreMatchers.is(2));	
    }
}
