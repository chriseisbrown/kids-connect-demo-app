package com.kidsconnect.domain.data;

import com.kidsconnect.domain.model.Review;

public interface ReviewData {

    public String getId();
    public String getActivityId();
    public String getUserName();
    public String getUserDisplayName();
    public String getDatetime();
    public String getRating();
    public String getNarrative();
    
    Review makeDomainWrapper();
  
}
