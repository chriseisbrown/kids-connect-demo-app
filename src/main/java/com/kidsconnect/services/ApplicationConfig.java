package com.kidsconnect.services;

import java.util.Arrays;

//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kidsconnect.domain.ActivityFinder;
import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.data.impl.PojoActivityData;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.external.ObjectMapperFactory;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.impl.PojoVenueFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ActivityType;
import com.kidsconnect.domain.model.AgeRange;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Venue;


@Configuration
public class ApplicationConfig
{
    @Bean
    public ObjectMapper objectMapper()
    {
        return ObjectMapperFactory.newObjectMapper();
    }

    
    @Bean
    public VenueFinder venueFinder()
    {
	return new PojoVenueFinder(VenueFinderData.datafromCSV());
    }
    
    
    @Bean
    public ActivityFinder activityFinder()
    {
	return new PojoActivityFinder(ActivityFinderData.datafromCSV());
    }
}
