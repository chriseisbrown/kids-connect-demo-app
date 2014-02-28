package com.kidsconnect.domain.model;

public abstract class Criteria<Entity extends DomainClass>
{
    public abstract void accept(CriteriaVisitor<Entity> visitor);
    
    public CriteriaChain<Entity> attach(Criteria<Entity> criteria)
    {
        return new CriteriaChain<Entity>(this, criteria);
    }
}
