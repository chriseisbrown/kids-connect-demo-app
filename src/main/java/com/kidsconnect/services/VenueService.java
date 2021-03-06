package com.kidsconnect.services;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.data.impl.PojoVenueData;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.Venue;


@Component
@Path("/venues")
public class VenueService extends EntityService<Venue>{

    private static final Logger LOG = LoggerFactory.getLogger(VenueService.class);

    private final VenueFinder finder;
    private final ObjectMapper objectMapper;

    private final SerializationConfig master;
    private final SerializationConfig detail;
    
    
    @Autowired
    public VenueService(ObjectMapper objectMapper, VenueFinder finder)
    {
        this.finder = finder;
        this.objectMapper = objectMapper;
        
        SerializationConfig basicSerializationConfig = this.objectMapper.getSerializationConfig();

        this.master = basicSerializationConfig.withView(com.kidsconnect.domain.external.DomainView.Master.class);
        this.detail = basicSerializationConfig.withView(com.kidsconnect.domain.external.DomainView.Detail.class);
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response search(@Context HttpServletRequest request,
			  @QueryParam("q") String query)
    {
	try
	{
	    HttpSession session = request.getSession(true);
	    /*Object sessionObject = session.getAttribute(SimpleUserContextManager.SESSION_USER);
	    if(sessionObject != null){
		UserContext userContext = (UserContext)sessionObject;
		String userName = userContext.getUserName();
		LOG.info("{} searching for venue data.", userName);
	}
	*/	
	    //TODO: fix this
	    //this.objectMapper.setSerializationConfig(this.master);
	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);
	    
	    int resultSize = 10;
	    long paginationIndex = 0;
	    String userid = "";
	    
	    Criteria<Venue> criteria = this.buildCriteria(null, query, resultSize, paginationIndex, userid);
	    LOG.info("Searching for VENUE data with query " + query);	    
            return Response.ok(this.finder.findMany(criteria)).build();
	}
	catch (IllegalArgumentException e)
	{
	    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
	}
	catch (Exception e)
	{
	    LOG.error("Unable to fetch VENUE details.", e);
	    return Response.serverError().build();
	}
    }
    
    
    @GET
    @Path("/{venueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response details(@PathParam("venueId") String venueId)
    {
        try
        {
            Venue venue = this.finder.findOne(venueId);
            if (null == venue)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);
	    return Response.ok(venue).build();
        }
        catch (Exception e)
        {
            LOG.error("Unable to fetch details for venueId: " + venueId, e);
            return Response.serverError().build();
        }
    }
}
