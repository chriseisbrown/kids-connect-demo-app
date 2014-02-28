package com.kidsconnect.domain.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


import com.google.common.collect.Lists;
import com.kidsconnect.domain.model.CriteriaChain;
import com.kidsconnect.domain.model.CriteriaVisitor;
import com.kidsconnect.domain.model.DomainClass;
import com.kidsconnect.domain.model.PaginationCriteria;
import com.kidsconnect.domain.model.QueryCriteria;
import com.kidsconnect.domain.model.ResultSizeCriteria;


public class PojoCriteriaVisitor<Entity extends DomainClass> implements CriteriaVisitor<Entity>
{
    private final List<String> queries = Lists.newArrayList();  //mutable list
    
    private long paginationIndex = 0;//record number not page number 
    
    private int resultSize = 0;

    
    public void visit(QueryCriteria<Entity> criteria){
        if (StringUtils.isNotBlank(criteria.getQuery()))
        {
            String query = criteria.getQuery();
            //this.queries.add(query.endsWith("*") ? query : query + "*");
            this.queries.add(query);
        }
    }
    
 
    public String applyTo(String query)
    {
	if(!this.queries.isEmpty()){
	    for(String s: queries){
		query += s;
	    }
	}
        return query;
    }
    
    @Override
    public void visit(PaginationCriteria<Entity> criteria)
    {
        this.paginationIndex =  criteria.getIndex();
    }

    
    @Override
    public void visit(CriteriaChain<Entity> criteria)
    {
	criteria.getLeft().accept(this);
	criteria.getRight().accept(this);
    }

    
    @Override
    public void visit(ResultSizeCriteria<Entity> criteria)
    {
	this.resultSize = criteria.getSize();
    }
}
