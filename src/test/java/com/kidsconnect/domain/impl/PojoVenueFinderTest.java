package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.CriteriaChain;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.ResultSizeCriteria;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.services.VenueFinderData;



public class PojoVenueFinderTest {

    List<Venue> venueList;
    
    
    @Before
    public void setUp()
    {
	this.venueList = VenueFinderData.data();
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
    public void findManyWithResultsSizeSetReturnsCorrectAmountOfResults() {
	
	int expectedResultSize = 1;
	ResultSizeCriteria<Venue> resultSizeCriteria = new ResultSizeCriteria<Venue>(expectedResultSize);
	QueryCriteria<Venue> criteria = new QueryCriteria<Venue>(new String("PlayBus"));
	CriteriaChain<Venue> chain = criteria.attach(resultSizeCriteria);
	
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(chain);
	assertEquals(expectedResultSize, venues.size());
    }

    @Test
    public void findManyIsCaseInsensitive() {

	Venue v = VenueFinderData.POJO_VENUE_DATA_7;

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
    public void findManyIsASearchAcrossAttributesOfAVenue() {

	
	Venue expectedVenues[] = {VenueFinderData.POJO_VENUE_DATA_7,
				VenueFinderData.POJO_VENUE_DATA_10};

	List<Venue> expectedVenuesList = Arrays.asList(expectedVenues);

	QueryCriteria<Venue> criteria = new QueryCriteria<Venue>(new String("pri"));
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(criteria);
	assertEquals(expectedVenuesList.size(), venues.size());
	
	ImmutableList<Venue> results = venues.getResults();
	
	for (Venue venue : expectedVenuesList){
	    assertTrue(results.contains(venue));
	}
	
    }
    
    @Test
    public void findManyWithNoQueryParameterSetGivesBackAllElements() {
	
	// if no query parameter is received then only a resultSize criteria will be passed in
	// and result will be all elements in the collection
	int resultSize = 25;
	ResultSizeCriteria<Venue> result = new ResultSizeCriteria<Venue>(resultSize);
	
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(result);
	assertEquals(this.venueList.size(), venues.size());
    }
    
    @Test
    public void findManyWithNoQueryParameterSetAndResultsSizeSetGivesBackResultSizeElements() {
	
	// expect to limit the amount of results coming back
	int resultSize = 2;
	ResultSizeCriteria<Venue> result = new ResultSizeCriteria<Venue>(resultSize);
	
	ResultSet<Venue> venues = new PojoVenueFinder(this.venueList).findMany(result);
	assertEquals(2, venues.size());
    }
    
}
