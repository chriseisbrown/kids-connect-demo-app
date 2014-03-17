package com.kidsconnect.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kidsconnect.domain.ActivityFinder;
import com.kidsconnect.domain.ReviewFinder;
import com.kidsconnect.domain.VenueFinder;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.DeepActivity;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Review;
import com.kidsconnect.domain.model.Venue;


@Component
@Path("/activities")
public class ActivityService extends EntityService<Activity>{

    private static final Logger LOG = LoggerFactory.getLogger(ActivityService.class);

    private final ActivityFinder activityFinder;
    private final VenueFinder venuefinder;
    private final ReviewFinder reviewfinder;
    private final ObjectMapper objectMapper;
   
    
    @Autowired
    public ActivityService(ObjectMapper objectMapper,
	    		   ActivityFinder finder,
	    		   VenueFinder venueFinder,
	    		   ReviewFinder reviewFinder)
    {
        this.activityFinder = finder;
        this.venuefinder = venueFinder;
        this.reviewfinder = reviewFinder;
        this.objectMapper = objectMapper;
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response search(@Context HttpServletRequest request,
			  @QueryParam("q") String query)
    {
	try
	{
	    HttpSession session = request.getSession(true);

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);
	    
	    int resultSize = 10;
	    long paginationIndex = 0;
	    String userid = "";
	    
	    @SuppressWarnings("unchecked")
	    Map<String, String[]> m = (Map<String, String[]>)request.getParameterMap();
	    
	    Criteria<Activity> criteria = this.buildCriteria(null, query, resultSize, paginationIndex, userid, m);
	    LOG.info("Searching for ACTIVITY data with query= " + query + " map=" + m.toString());	    
            return Response.ok(this.activityFinder.findMany(criteria)).build();
	}
	catch (IllegalArgumentException e)
	{
	    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
	}
	catch (Exception e)
	{
	    LOG.error("Unable to fetch ACTIVITY details.", e);
	    return Response.serverError().build();
	}
    }
    
    
    @GET
    @Path("/{activityId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response details(@PathParam("activityId") String activityId)
    {
        try
        {
            Activity activity = this.activityFinder.findOne(activityId);
            if (null == activity)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }   
            
            Venue venue = this.venuefinder.findOne(activity.getVenueId());
            if (null == venue)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            
            DeepActivity deepActivity = new DeepActivity(activity, venue);
            
            ResultSet<Review> reviews = this.reviewfinder.findByActivity(activityId);
            if (reviews.getTotalResultsSize() > 0)
            {
                deepActivity.setReviews(reviews.getResults());
            }

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Deep.class);
	    return Response.ok(deepActivity).build();
        }
        catch (Exception e)
        {
            LOG.error("Unable to fetch details for activityId: " + activityId, e);
            return Response.serverError().build();
        }
    }
    
    
    @GET
    @Path("/venue/{venueId}")
    @Produces(MediaType.APPLICATION_JSON)   
    public Response activityAtVenue(@Context HttpServletRequest request,
	    				@PathParam("venueId") String venueId)
    {
	try
	{
	    HttpSession session = request.getSession(true);

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);	  
	    
	    LOG.info("Searching for ACTIVITY data at venueId " + venueId);	    
            return Response.ok(this.activityFinder.findByVenue(venueId)).build();
	}
	catch (IllegalArgumentException e)
	{
	    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
	}
	catch (Exception e)
	{
	    LOG.error("Unable to fetch ACTIVITY details.", e);
	    return Response.serverError().build();
	}
    }

}
