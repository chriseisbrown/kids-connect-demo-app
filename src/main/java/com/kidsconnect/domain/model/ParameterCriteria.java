package com.kidsconnect.domain.model;

import java.util.Map;

import org.apache.commons.lang3.Validate;

public class ParameterCriteria<Entity extends DomainClass> extends Criteria<Entity>{
    
    private final Map<String, String[]> parameters;

    public ParameterCriteria(Map<String, String[]> parameters)
    {
        Validate.notEmpty(parameters, "Parameters argument must not be null or empty");
        this.parameters = parameters;
    }

    public Map<String, String[]> getParameters()
    {
        return parameters;
    }

    @Override
    public void accept(CriteriaVisitor<Entity> visitor)
    {
        visitor.visit(this);
    }
    
}


