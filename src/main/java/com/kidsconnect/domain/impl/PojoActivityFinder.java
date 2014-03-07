package com.kidsconnect.domain.impl;

import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.kidsconnect.domain.ActivityFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.Pagination;
import com.kidsconnect.domain.model.ResultSet;



public class PojoActivityFinder implements ActivityFinder {

    private static final String BOOK = "book";
    
    private FluentIterable<Activity> activities;
    
    
    public PojoActivityFinder(FluentIterable<Activity> activities)
    {
        this.activities = activities;
    }
    
    
    public PojoActivityFinder(Iterable<Activity> activities)
    {
        this.activities = FluentIterable.from(activities);
    }

    
    @Override
    public Activity findOne(final String activityId)
    {
	Predicate<Activity> p = new Predicate<Activity>(){	    
	    @Override
	    public boolean apply(Activity activity)
	    {
	        return activity.getId().equals(activityId);
	    }
	};
	
	return Iterables.find(activities, p, null);
    }
    

    @Override
    public ResultSet<Activity> findAll()
    {
        return new ResultSet<Activity>(this.activities,
        	                    new Pagination(this.activities.size(), this.activities.size(), 0),
        	                    Activity.class.getSimpleName());
    }
    

    @SuppressWarnings("unchecked")
    @Override
    public ResultSet<Activity> findMany(final Criteria<? extends Activity> criteria)
    {
        final PojoCriteriaVisitor<Activity> visitor = new PojoCriteriaVisitor<Activity>();
        ((Criteria<Activity>) criteria).accept(visitor);
        
        String q = "";
        final String query = visitor.applyTo(q);
        
        int maxResults = 0; 
        final int maxResultsReturned = visitor.applyTo(maxResults);
        
        Map<String, String[]> queryMap = Maps.newHashMap();
        final Map<String, String[]> qMap = visitor.applyTo(queryMap);
	
	Predicate<Activity> queryPredicate = new Predicate<Activity>(){	    
    	    @Override
    	    public boolean apply(Activity activity)
    	    {
    	        return activity.getName().toLowerCase().contains(query.toLowerCase())
    	               || activity.getDescription().toLowerCase().contains(query.toLowerCase());
    	    }
    	};    
	
    	ImmutableList<Activity> queryfilteredActivities = ImmutableList.copyOf(Iterables.filter(activities, queryPredicate));
    	
    	if(qMap.containsKey(BOOK)){
    	    
    	    final String[] bookingParam = qMap.get(BOOK);
    	    final String bookingRequired = bookingParam[0];
    	    
    	    Predicate<Activity> bookedPredicate = new Predicate<Activity>(){	    
    		@Override
    		public boolean apply(Activity activity)
    		{
    		    return activity.getBookingRequired() == Boolean.parseBoolean(bookingRequired);
    		}
    	    };

    	    queryfilteredActivities = ImmutableList.copyOf(Iterables.filter(queryfilteredActivities, bookedPredicate));

    	}
 
    	
    	if(maxResultsReturned != 0 && queryfilteredActivities.size() > maxResultsReturned){
    	    queryfilteredActivities = queryfilteredActivities.subList(0, maxResultsReturned);
    	}
    	
    	
    	ResultSet<Activity> r = new ResultSet<Activity>(queryfilteredActivities,
    		 				  new Pagination(queryfilteredActivities.size(), this.activities.size(), 0),
    		 				  Activity.class.getSimpleName());
    	return r;
    }
    
    
    @Override
    public ResultSet<Activity> findByVenue(final String venueId)
    {
	//TODO: fix this method to do things "properly"
        final int maxResultsReturned = 10;
	
	    Predicate<Activity> p = new Predicate<Activity>(){	    
    	    @Override
    	    public boolean apply(Activity activity)
    	    {
    	        return activity.getVenueId().equals(venueId);
    	    }
    	};    
	
    	ImmutableList<Activity> filteredActivities = ImmutableList.copyOf(Iterables.filter(activities, p));
    	
    	if(maxResultsReturned != 0 && filteredActivities.size() > maxResultsReturned){
    	    filteredActivities = filteredActivities.subList(0, maxResultsReturned);
    	}
    	
    	ResultSet<Activity> r = new ResultSet<Activity>(filteredActivities,
    		 				  new Pagination(filteredActivities.size(), this.activities.size(), 0),
    		 				  Activity.class.getSimpleName());
    	return r;
    }

}
