package com.kidsconnect.domain.model;

import com.google.common.collect.ImmutableList;

public class DeepActivity {

    private Activity activity;
    private Venue venue;
    private ImmutableList<Review> reviews;

    public DeepActivity(Activity activity, Venue venue) {

	this.activity = activity;
	this.venue = venue;
    }

    public Activity getActivity() {
        return activity;
    }

    public Venue getVenue() {
        return venue;
    }
    
    public ImmutableList<Review> getReviews(){
	return reviews;
    }
    
    public void setReviews(ImmutableList<Review> reviews){
	this.reviews = reviews;
    }
    
    
}
