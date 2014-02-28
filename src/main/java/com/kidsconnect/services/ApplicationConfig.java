package com.kidsconnect.services;

import java.util.Arrays;

//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.external.ObjectMapperFactory;
import com.kidsconnect.domain.impl.PojoVenueFinder;
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
		  new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley" ).makeDomainWrapper(),
		  new PojoVenueData("8", "Etheldred Day Centre", "92 Florence Road").makeDomainWrapper(),
		  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper(),
		  new PojoVenueData("9", "PlayBus", "All over").makeDomainWrapper()};
		
        return new PojoVenueFinder(Arrays.asList(v));
    }
}
