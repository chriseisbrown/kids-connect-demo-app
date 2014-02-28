package com.kidsconnect.domain.model;


public class PaginationCriteria<Entity extends DomainClass> extends Criteria<Entity>
{
    private final long index;

    public PaginationCriteria(long index)
    {
        this.index = index;
    }

    public long getIndex()
    {
        return index;
    }

   @Override
    public void accept(CriteriaVisitor<Entity> visitor)
    {
        visitor.visit(this);
    }
}
