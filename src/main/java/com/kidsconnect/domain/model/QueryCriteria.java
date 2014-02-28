package com.kidsconnect.domain.model;

import org.apache.commons.lang3.Validate;

public class QueryCriteria<Entity extends DomainClass> extends Criteria<Entity>
{
    private final String query;

    public QueryCriteria(String query)
    {
        Validate.notEmpty(query, "Query argument must not be null or empty");
        this.query = query;
    }

    public String getQuery()
    {
        return query;
    }

    @Override
    public void accept(CriteriaVisitor<Entity> visitor)
    {
        visitor.visit(this);
    }
    
}


