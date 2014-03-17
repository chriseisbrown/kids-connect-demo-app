package com.kidsconnect.domain.data.impl;

import org.joda.time.DateTime;

import com.kidsconnect.domain.data.ReviewData;
import com.kidsconnect.domain.data.VenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Review;
import com.kidsconnect.domain.model.Venue;


public class PojoReviewData implements ReviewData {

    public String reviewId;
    public String activityId;
    public String userName;
    public String userDisplayName;
    public DateTime datetime;
    public String rating;
    public String narrative;
    
    
    public PojoReviewData(String reviewId, String activityId, String userName,
	    String userDisplayName, DateTime datetime, String rating,
	    String narrative) {
	super();
	this.reviewId = reviewId;
	this.activityId = activityId;
	this.userName = userName;
	this.userDisplayName = userDisplayName;
	this.datetime = datetime;
	this.rating = rating;
	this.narrative = narrative;
    }


    public String getId() {
        return reviewId;
    }


    public String getActivityId() {
        return activityId;
    }


    public String getUserName() {
        return userName;
    }


    public String getUserDisplayName() {
        return userDisplayName;
    }


    public DateTime getDatetime() {
        return datetime;
    }


    public String getRating() {
        return rating;
    }


    public String getNarrative() {
        return narrative;
    }


    @Override
    public Review makeDomainWrapper() {
	return new Review(this);
    }

    @Override
    public String toString() {
	return "PojoReviewData [reviewId=" + reviewId + ", activityId="
		+ activityId + ", userName=" + userName + ", userDisplayName="
		+ userDisplayName + ", datetime=" + datetime + ", rating="
		+ rating + ", narrative=" + narrative + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((activityId == null) ? 0 : activityId.hashCode());
	result = prime * result
		+ ((datetime == null) ? 0 : datetime.hashCode());
	result = prime * result + ((rating == null) ? 0 : rating.hashCode());
	result = prime * result
		+ ((reviewId == null) ? 0 : reviewId.hashCode());
	result = prime * result
		+ ((userName == null) ? 0 : userName.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	PojoReviewData other = (PojoReviewData) obj;
	if (activityId == null) {
	    if (other.activityId != null)
		return false;
	} else if (!activityId.equals(other.activityId))
	    return false;
	if (datetime == null) {
	    if (other.datetime != null)
		return false;
	} else if (!datetime.equals(other.datetime))
	    return false;
	if (rating == null) {
	    if (other.rating != null)
		return false;
	} else if (!rating.equals(other.rating))
	    return false;
	if (reviewId == null) {
	    if (other.reviewId != null)
		return false;
	} else if (!reviewId.equals(other.reviewId))
	    return false;
	if (userName == null) {
	    if (other.userName != null)
		return false;
	} else if (!userName.equals(other.userName))
	    return false;
	return true;
    }

    
}
