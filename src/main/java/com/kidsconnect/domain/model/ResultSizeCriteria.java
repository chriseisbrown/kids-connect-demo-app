package com.kidsconnect.domain.model;


public class ResultSizeCriteria<Entity extends DomainClass> extends Criteria<Entity>
{
    private final int size;

    public ResultSizeCriteria(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return size;
    }

    @Override
    public void accept(CriteriaVisitor<Entity> visitor)
    {
        visitor.visit(this);
    }
}
