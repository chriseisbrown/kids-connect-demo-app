package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Review;
import com.kidsconnect.services.ReviewFinderData;


public class PojoReviewFinderTest {

    static List<Review> reviewList;
 
    
    @BeforeClass
    public static void setUp()
    {
	reviewList = ReviewFinderData.data();
    }
    
    @Test
    public void dontfindOneNotInList() {

	final String id = "77";
	Review review = new PojoReviewFinder(PojoReviewFinderTest.reviewList).findOne(id);
	assertNull(review);
    }

    @Test
    public void findOneInList() {

	final String id = "7";
	Review review = new PojoReviewFinder(PojoReviewFinderTest.reviewList).findOne(id);
	System.out.println(review);
	assertEquals(id, review.getId());
	assertEquals(ReviewFinderData.POJO_REVIEW_DATA_7, review);
    }
    
    @Test
    public void findAll() {
	ResultSet<Review> reviews = new PojoReviewFinder(PojoReviewFinderTest.reviewList).findAll();
	assertEquals(reviews.size(), reviewList.size());
    }

    @Test
    public void findMany() {
	
	QueryCriteria<Review> criteria = new QueryCriteria<Review>(new String("Dads"));
	ResultSet<Review> reviews = new PojoReviewFinder(PojoReviewFinderTest.reviewList).findMany(criteria);
	assertEquals(1, reviews.size());
    }
    
    
    @Test
    public void findByActivity() {
	
	String activityId = "1019";
	
	List<Review> expectedReviewsList = Arrays.asList(new Review[]{	
	            ReviewFinderData.POJO_REVIEW_DATA_7,
	            ReviewFinderData.POJO_REVIEW_DATA_8,
	            ReviewFinderData.POJO_REVIEW_DATA_9
	});
	
	ResultSet<Review> reviewsForVenue = new PojoReviewFinder(PojoReviewFinderTest.reviewList).findByActivity(activityId);
	assertEquals(expectedReviewsList.size(), reviewsForVenue.size());
	
	ImmutableList<Review> results = reviewsForVenue.getResults();
	
	for (Review review : expectedReviewsList){
	    assertTrue(results.contains(review));
	}
    }
    

}
