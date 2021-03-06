package com.kidsconnect.domain.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.Pagination;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Venue;


public class PojoVenueFinder implements VenueFinder {

    private FluentIterable<Venue> venues;
    
    
    public PojoVenueFinder(FluentIterable<Venue> venues)
    {
        this.venues = venues;
    }
    
    
    public PojoVenueFinder(Iterable<Venue> venues)
    {
        this.venues = FluentIterable.from(venues);
    }

    
    @Override
    public Venue findOne(final String venueId)
    {
	Predicate<Venue> p = new Predicate<Venue>(){	    
	    @Override
	    public boolean apply(Venue venue)
	    {
	        return venue.getId().equals(venueId);
	    }
	};
	
	return Iterables.find(venues, p, null);
    }
    

    @Override
    public ResultSet<Venue> findAll()
    {
        return new ResultSet<Venue>(this.venues,
        	                    new Pagination(this.venues.size(), this.venues.size(), 0),
        	                    Venue.class.getSimpleName());
    }
    

    @SuppressWarnings("unchecked")
    @Override
    public ResultSet<Venue> findMany(final Criteria<? extends Venue> criteria)
    {
        final PojoCriteriaVisitor<Venue> visitor = new PojoCriteriaVisitor<Venue>();
        ((Criteria<Venue>) criteria).accept(visitor);
        
        String q = "";
        final String query = visitor.applyTo(q);
        
        int maxResults = 0; 
        final int maxResultsReturned = visitor.applyTo(maxResults);
	
	Predicate<Venue> p = new Predicate<Venue>(){	    
	    @Override
	    public boolean apply(Venue venue)
	    {
	        return venue.getName().toLowerCase().contains(query.toLowerCase())
	        	|| venue.getAddress().toLowerCase().contains(query.toLowerCase());
	    }
	};    
	
	ImmutableList<Venue> filteredVenues = ImmutableList.copyOf(Iterables.filter(venues, p));
	
	if(maxResultsReturned != 0 && filteredVenues.size() > maxResultsReturned){
	    filteredVenues = filteredVenues.subList(0, maxResultsReturned);
	}
	
	ResultSet<Venue> r = new ResultSet<Venue>(filteredVenues,
		 				  new Pagination(filteredVenues.size(), this.venues.size(), 0),
		 				  Venue.class.getSimpleName());
	return r;
    }
    
}
