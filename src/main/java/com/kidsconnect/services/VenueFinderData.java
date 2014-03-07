package com.kidsconnect.services;

import java.util.Arrays;
import java.util.List;

import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Venue;

public class VenueFinderData {

    public static List<Venue> data(){
    
	Venue v[] = new Venue[]{
	new PojoVenueData("7", "Bickley Primary School", "Nightingale Road, Bickley", new Borough("Southwark"), new PostCode("BR1 2BT"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("8", "Etheldred Day Centre", "92 Florence Road", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("9", "PlayBus", "All over", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("9", "PlayBus", "All over", new Borough("Southwark"), new PostCode("SE15 6XX"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("10", "Martha Biggles House", "18 Priory Road, Southwark", new Borough("Southwark"), new PostCode("SE15 6BP"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("101", "The Grove Children and Family Centre", "Tower Mill Road", new Borough("Southwark"), new PostCode("SE15 6BP"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("102", "Albrighton Community Centre", "Albrighton Road, East Dulwich Estate", new Borough("Southwark"), new PostCode("SE22 8AH"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("103", "Bessemer Grange Children\'s Centre", "Dylways", new Borough("Southwark"), new PostCode("SE5 8HP"), new Location(0,0)).makeDomainWrapper(),
	new PojoVenueData("104", "Coin Street family and children's centre (Borough)", "108 Stamford Street", new Borough("Southwark"), new PostCode("SE1 9NH"), new Location(0,0)).makeDomainWrapper()};
	return Arrays.asList(v);
    }
}
