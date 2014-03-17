package com.kidsconnect.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidsconnect.domain.ActivityFinder;
import com.kidsconnect.domain.ReviewFinder;
import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.external.ObjectMapperFactory;
import com.kidsconnect.domain.impl.PojoActivityFinder;
import com.kidsconnect.domain.impl.PojoReviewFinder;
import com.kidsconnect.domain.impl.PojoVenueFinder;
//import org.codehaus.jackson.map.ObjectMapper;


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
    
    
    @Bean
    public ReviewFinder reviewFinder()
    {
	return new PojoReviewFinder(ReviewFinderData.datafromCSV());
    }
}
