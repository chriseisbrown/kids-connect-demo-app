package com.kidsconnect.domain.data;

import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.Venue;

public interface VenueData {

    public String getName();
    public String getAddress();
    public String getId();
    public Location getLocation();
    
    Venue makeDomainWrapper();
    
}
