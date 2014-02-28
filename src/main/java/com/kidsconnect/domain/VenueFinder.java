package com.kidsconnect.domain;

import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.Venue;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSet;



public interface VenueFinder extends Finder<Venue>
{
    @Override
    Venue findOne(String key);

    @Override
    ResultSet<Venue> findAll();

    ResultSet<Venue> findMany(Criteria<? extends Venue> criteria);
}
