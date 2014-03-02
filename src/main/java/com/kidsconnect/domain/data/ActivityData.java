package com.kidsconnect.domain.data;

import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;

public interface ActivityData {

    public String getName();
    public ActivityType getType();
    public String getId();
    public AgeRange getAgeRange();
    public String getDescription();

    Activity makeDomainWrapper();    
}
