package com.kidsconnect.domain.model;

import org.joda.time.format.DateTimeFormat;

import com.kidsconnect.domain.data.ReviewData;



public class Review implements DomainClass
{
    private ReviewData delegate;
    
    
    public Review(ReviewData delegate)
    {
	this.delegate = delegate;
    }  

    public String getId() {
	return delegate.getId();
    }

    public String getActivityId() {
        return delegate.getActivityId();
    }

    public String getUserName() {
        return delegate.getUserName();
    }

    public String getUserDisplayName() {
        return delegate.getUserDisplayName();
    }

    public String getDatetime() {
        return delegate.getDatetime().toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm"));
    }

    public String getRating() {
        return delegate.getRating();
    }

    public String getNarrative() {
        return delegate.getNarrative();
    }

    @Override
    public String toString() {
	return "Review [delegate=" + delegate + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((delegate == null) ? 0 : delegate.hashCode());
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
	Review other = (Review) obj;
	if (delegate == null) {
	    if (other.delegate != null)
		return false;
	} else if (!delegate.equals(other.delegate))
	    return false;
	return true;
    }
    
}
