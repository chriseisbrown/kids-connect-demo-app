package com.kidsconnect.services;

import java.util.Arrays;
import java.util.List;

import com.kidsconnect.domain.data.impl.PojoReviewData;
import com.kidsconnect.domain.impl.helper.ActivityCSVFileReader;
import com.kidsconnect.domain.impl.helper.ReviewCSVFileReader;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Borough;
import com.kidsconnect.domain.model.Location;
import com.kidsconnect.domain.model.PostCode;
import com.kidsconnect.domain.model.Review;

public class ReviewFinderData {
    
    private static ReviewCSVFileReader reviewFileReader = new ReviewCSVFileReader();

    public static Review POJO_REVIEW_DATA_7 = reviewFileReader.get("7"); 
    public static Review POJO_REVIEW_DATA_8 = reviewFileReader.get("8");
    public static Review POJO_REVIEW_DATA_9 = reviewFileReader.get("9");

    
    public static List<Review> data(){
    
	Review v[] = new Review[]{
                		POJO_REVIEW_DATA_7,
                		POJO_REVIEW_DATA_8,
                		POJO_REVIEW_DATA_9
		};
	return Arrays.asList(v);
    }
    
    
    public static List<Review> datafromCSV(){
	return reviewFileReader.data();
    }
}
