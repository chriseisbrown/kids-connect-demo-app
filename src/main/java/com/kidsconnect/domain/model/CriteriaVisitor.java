package com.kidsconnect.domain.model;


public interface CriteriaVisitor<Entity extends DomainClass>
{
    void visit(QueryCriteria<Entity> criteria);
    
    void visit(PaginationCriteria<Entity> criteria);
    
    void visit(CriteriaChain<Entity> criteria);
    
    void visit(ResultSizeCriteria<Entity> criteria);

    void visit(ParameterCriteria<Entity> criteria);

}
