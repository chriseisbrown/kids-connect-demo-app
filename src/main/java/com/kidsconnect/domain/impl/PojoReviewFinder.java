package com.kidsconnect.domain.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.kidsconnect.domain.ReviewFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.Pagination;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Review;


public class PojoReviewFinder implements ReviewFinder {

    private FluentIterable<Review> reviews;
    
    
    public PojoReviewFinder(FluentIterable<Review> reviews)
    {
        this.reviews = reviews;
    }
    
    
    public PojoReviewFinder(Iterable<Review> reviews)
    {
        this.reviews = FluentIterable.from(reviews);
    }

    
    @Override
    public Review findOne(final String reviewId)
    {
	Predicate<Review> p = new Predicate<Review>(){	    
	    @Override
	    public boolean apply(Review review)
	    {
	        return review.getId().equals(reviewId);
	    }
	};
	
	return Iterables.find(reviews, p, null);
    }
    

    @Override
    public ResultSet<Review> findAll()
    {
        return new ResultSet<Review>(this.reviews,
        	                    new Pagination(this.reviews.size(), this.reviews.size(), 0),
        	                    Review.class.getSimpleName());
    }
    

    @SuppressWarnings("unchecked")
    @Override
    public ResultSet<Review> findMany(final Criteria<? extends Review> criteria)
    {
        final PojoCriteriaVisitor<Review> visitor = new PojoCriteriaVisitor<Review>();
        ((Criteria<Review>) criteria).accept(visitor);
        
        String q = "";
        final String query = visitor.applyTo(q);
        
        int maxResults = 0; 
        final int maxResultsReturned = visitor.applyTo(maxResults);
	
	Predicate<Review> p = new Predicate<Review>(){	    
	    @Override
	    public boolean apply(Review review)
	    {
	        return review.getNarrative().toLowerCase().contains(query.toLowerCase());
	    }
	};    
	
	ImmutableList<Review> filteredReviews = ImmutableList.copyOf(Iterables.filter(reviews, p));
	
	if(maxResultsReturned != 0 && filteredReviews.size() > maxResultsReturned){
	    filteredReviews = filteredReviews.subList(0, maxResultsReturned);
	}
	
	ResultSet<Review> r = new ResultSet<Review>(filteredReviews,
		 				  new Pagination(filteredReviews.size(), this.reviews.size(), 0),
		 				  Review.class.getSimpleName());
	return r;
    }
    
    
    @Override
    public ResultSet<Review> findByActivity(final String activityId)
    {
	//TODO: fix this method to do things "properly"
        final int maxResultsReturned = 10;
	
	    Predicate<Review> p = new Predicate<Review>(){	    
    	    @Override
    	    public boolean apply(Review review)
    	    {
    	        return review.getActivityId().equals(activityId);
    	    }
    	};    
	
    	ImmutableList<Review> filteredActivities = ImmutableList.copyOf(Iterables.filter(reviews, p));
    	
    	if(maxResultsReturned != 0 && filteredActivities.size() > maxResultsReturned){
    	    filteredActivities = filteredActivities.subList(0, maxResultsReturned);
    	}
    	
    	ResultSet<Review> r = new ResultSet<Review>(filteredActivities,
    		 				  new Pagination(filteredActivities.size(), this.reviews.size(), 0),
    		 				Review.class.getSimpleName());
    	return r;
    }
}
