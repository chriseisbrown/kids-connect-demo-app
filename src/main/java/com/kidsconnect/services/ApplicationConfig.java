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
	Venue v[] = new Venue[]{
	new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley", new Borough("Southwark"), new PostCode("BR1 2BT"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("8", "Etheldred Day Centre", "92 Florence Road", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("9", "PlayBus", "All over", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("9", "PlayBus", "All over", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("10", "Martha Biggles House", "18 Priory Road, Southwark", new Borough("Southwark"), new PostCode("SE15 6BP"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("101", "The Grove Children and Family Centre", "Tower Mill Road", new Borough("Southwark"), new PostCode("SE15 6BP"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("102", "Albrighton Community Centre", "Albrighton Road, East Dulwich Estate", new Borough("Southwark"), new PostCode("SE22 8AH"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("103", "Bessemer Grange Children\'s Centre", "Dylways", new Borough("Southwark"), new PostCode("SE5 8HP"), new Location(0,0)).makeDomainWrapper()};
        return new PojoVenueFinder(Arrays.asList(v));
    }
    
    
    @Bean
    public ActivityFinder activityFinder()
    {
	Activity a[] = new Activity[]{
		new PojoActivityData("1001", "Holiday stay and play sessions", ActivityType.STAYANDPLAY,
		    "Easter fun activities for all children.", AgeRange.YRS8ANDUNDER, "102").makeDomainWrapper(),
		new PojoActivityData("1010", "Stay and play for babies and toddlers", ActivityType.STAYANDPLAY, 
	            "A session for both babies and toddlers to play.", AgeRange.YRS5ANDUNDER, "103").makeDomainWrapper(),
	        new PojoActivityData("1019", "Diddi dance", ActivityType.MUSICANDDANCE, 
	        	    "Music and movement sessions. Term time only.", AgeRange.FROM18MONTHS, "101").makeDomainWrapper(),
	        new PojoActivityData("1038", "Healthy fun time cooking", ActivityType.COOKING, 
	               "After school stay and play with a focus on cooking fun for kids.", AgeRange.YRS6ANDUNDER, "103").makeDomainWrapper()};

	return new PojoActivityFinder(Arrays.asList(a));
    }
}
