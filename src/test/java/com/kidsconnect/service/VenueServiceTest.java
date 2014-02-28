package com.kidsconnect.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

//import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.impl.PojoVenueFinder;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.services.VenueService;



public class VenueServiceTest {

    private VenueService serviceUnderTest;
    
    List<Venue> venueList;
  
    @Mock
    HttpServletRequest servletRequest;
    
    @Mock
    HttpSession session;    
  
    
    @Before
    public void setUp(){
	initMocks(this);
	
	Venue v[] = new Venue[]{
	  new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley" ).makeDomainWrapper(),
	  new PojoVenueData("8", "Etheldred Day Centre", "92 Florence Road").makeDomainWrapper(),
	  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper(),
	  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper()};
	
	this.venueList = Arrays.asList(v);
    }
 
    
    @SuppressWarnings("unchecked")
    @Test
    public void index(){
	
	when(servletRequest.getSession(true)).thenReturn(session);
	
	ObjectMapper mapper = new ObjectMapper();
	
	this.serviceUnderTest = new VenueService(mapper, new PojoVenueFinder(this.venueList));
	
	Response response = this.serviceUnderTest.index(servletRequest, "PlayBus");
	    
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        Assert.assertThat(response.getEntity(), CoreMatchers.is(ResultSet.class));

        ResultSet<Venue> resultSet = (ResultSet<Venue>) response.getEntity();
        Assert.assertThat(resultSet.size(), CoreMatchers.is(2));	
    }
}
