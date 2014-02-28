package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.ResultSizeCriteria;
import com.kidsconnect.domain.model.Venue;



public class PojoVenueFinderTest {

    List<Venue> venueList;
    
    
    @Before
    public void setUp()
    {
	Venue v[] = new Venue[]{new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley" ).makeDomainWrapper(),
				  new PojoVenueData("8", "Etheldred Day Centre", "92 Florence Road").makeDomainWrapper(),
				  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper(),
				  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper()};
	this.venueList = Arrays.asList(v);
	
    }
    
    @Test
    public void dontfindOneNotInList() {

	final String id = "77";
	Venue venue = new PojoVenueFinder(this.venueList).findOne(id);
	assertNull(venue);
    }

    @Test
    public void findOneInList() {

	final String id = "9";
	Venue venue = new PojoVenueFinder(this.venueList).findOne(id);
	System.out.println(venue);
	assertEquals(venue.getId(), id);
    }
    
    @Test
    public void findAll() {
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findAll();
	assertEquals(venues.size(), venueList.size());
    }

    @Test
    public void findMany() {
	
	QueryCriteria<Venue> criteria = new QueryCriteria<Venue>(new String("PlayBus"));
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(criteria);
	assertEquals(2, venues.size());
    }

    @Test
    public void findManyIsCaseInsensitive() {

	Venue v = new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley" ).makeDomainWrapper();
	
	QueryCriteria<Venue> criteriaUpper = new QueryCriteria<Venue>(new String("Primary"));
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(criteriaUpper);
	assertEquals(1, venues.size());
	
	ImmutableList<Venue> results = venues.getResults();
	
	if(venues.size() == 1){
	    for (Venue venue : results){
		assertEquals(v, venue);
	    }
	}
	
	QueryCriteria<Venue> criteriaLower = new QueryCriteria<Venue>(new String("primary"));
	ResultSet<Venue> otherVenues = new PojoVenueFinder(this.venueList).findMany(criteriaLower);
	assertEquals(1, otherVenues.size());
	
	ImmutableList<Venue> otherResults = otherVenues.getResults();
	
	if(otherVenues.size() == 1){
	    for (Venue venue : otherResults){
		assertEquals(v, venue);
	    }
	}
    }
    
    @Test
    public void findManyWithNoQueryParameterSetGivesBackAllElements() {
	
	// if no query parameter is received then only a result criteria will be passed in
	// and result will
	int resultSize = 25;
	ResultSizeCriteria<Venue> result = new ResultSizeCriteria<Venue>(resultSize);
	
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(result);
	assertEquals(4, venues.size());
    }
    
    @Test
    public void findManyWithNoQueryParameterSetAndResultsSizeSetGivesBackResultSizeElements() {
	
	// if no query parameter is received then only a result criteria will be passed in
	// and result will
	int resultSize = 2;
	ResultSizeCriteria<Venue> result = new ResultSizeCriteria<Venue>(resultSize);
	
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(result);
	assertEquals(2, venues.size());
    }
    
}
