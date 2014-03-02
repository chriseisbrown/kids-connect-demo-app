package com.kidsconnect.domain;

import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.ResultSet;


public interface ActivityFinder extends Finder<Activity>
{
    @Override
    Activity findOne(String key);

    @Override
    ResultSet<Activity> findAll();

    ResultSet<Activity> findMany(Criteria<? extends Activity> criteria);
}
