package com.kidsconnect.domain.model;

public class DeepActivity {

    private Activity activity;
    private Venue venue;

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
    
    
}
