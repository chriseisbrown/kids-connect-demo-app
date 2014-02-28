package com.kidsconnect.domain.model;

public class CriteriaChain<Entity extends DomainClass> extends Criteria<Entity>
{
    private Criteria<Entity> left;
    private Criteria<Entity> right;

    public CriteriaChain(Criteria<Entity> left, Criteria<Entity> right)
    {
        this.left = left;
        this.right = right;
    }

    public Criteria<Entity> getLeft()
    {
        return left;
    }

    public Criteria<Entity> getRight()
    {
        return right;
    }

    @Override
    public void accept(CriteriaVisitor<Entity> visitor)
    {
        visitor.visit(this);
    }
    
}
