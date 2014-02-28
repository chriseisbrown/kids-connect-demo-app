package com.kidsconnect.domain;

import com.kidsconnect.domain.model.DomainClass;
import com.kidsconnect.domain.model.ResultSet;

public interface Finder<Entity extends DomainClass>
{
    Entity findOne(String key);

    ResultSet<Entity> findAll();
}


