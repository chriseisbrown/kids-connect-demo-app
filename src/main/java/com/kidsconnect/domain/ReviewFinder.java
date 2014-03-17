package com.kidsconnect.domain;

import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.ResultSet;
import com.kidsconnect.domain.model.Review;


public interface ReviewFinder extends Finder<Review>
{
    @Override
    Review findOne(String key);

    @Override
    ResultSet<Review> findAll();

    ResultSet<Review> findMany(Criteria<? extends Review> criteria);
    
    ResultSet<Review> findByActivity(String activityId);
}
