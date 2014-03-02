package com.kidsconnect.services;

import org.apache.commons.lang3.StringUtils;

import com.kidsconnect.domain.model.Criteria;
import com.kidsconnect.domain.model.DomainClass;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSizeCriteria;


public abstract class EntityService<Entity extends DomainClass> {
    
    protected <E extends DomainClass> Criteria<E> buildCriteria(Criteria<E> criteria,
	    							String query,
								int resultSize,
								long paginationIndex, 
								String userid)
    {
	criteria = this.attachResultSizeCriteria(criteria, resultSize);
	criteria = this.attachQueryCriteria(criteria, query);
	return criteria;
    }
    

    protected <E extends DomainClass> Criteria<E> attachQueryCriteria(Criteria<E> criteria, String query)
    {
        if (StringUtils.isNotEmpty(query))
        {
            query = query.trim();
            Criteria<E> queryCriteria = new QueryCriteria<E>(query);
            criteria = null == criteria ? queryCriteria : criteria.attach(queryCriteria);
        }
        return criteria;
    }

    
    protected <E extends DomainClass> Criteria<E>  attachResultSizeCriteria(Criteria<E> criteria, int resultSize)
    {
        if(0 != resultSize)
        {
            ResultSizeCriteria<E> resultCriteria = new ResultSizeCriteria<E>(resultSize);
            criteria = null == criteria ? resultCriteria : criteria.attach(resultCriteria);
        }
        return criteria;
    }
}
