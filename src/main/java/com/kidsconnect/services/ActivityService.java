package com.kidsconnect.services;

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
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;


@Component
@Path("/activities")
public class ActivityService extends EntityService<Activity>{

    private static final Logger LOG = LoggerFactory.getLogger(ActivityService.class);

    private final ActivityFinder finder;
    private final ObjectMapper objectMapper;
   
    
    @Autowired
    public ActivityService(ObjectMapper objectMapper, ActivityFinder finder)
    {
        this.finder = finder;
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
	    /*Object sessionObject = session.getAttribute(SimpleUserContextManager.SESSION_USER);
	    if(sessionObject != null){
		UserContext userContext = (UserContext)sessionObject;
		String userName = userContext.getUserName();
		LOG.info("{} searching for venue data.", userName);
	}
	*/	

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);
	    
	    int resultSize = 10;
	    long paginationIndex = 0;
	    String userid = "";
	    
	    Criteria<Activity> criteria = this.buildCriteria(null, query, resultSize, paginationIndex, userid);
	    LOG.info("Searching for ACTIVITY data with query " + query);	    
            return Response.ok(this.finder.findMany(criteria)).build();
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
            Activity activity = this.finder.findOne(activityId);
            if (null == activity)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

	    this.objectMapper.getSerializationConfig().withView(com.kidsconnect.domain.external.DomainView.Master.class);
	    return Response.ok(activity).build();
        }
        catch (Exception e)
        {
            LOG.error("Unable to fetch details for activityId: " + activityId, e);
            return Response.serverError().build();
        }
    }
}