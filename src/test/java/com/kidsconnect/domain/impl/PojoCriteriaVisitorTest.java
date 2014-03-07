package com.kidsconnect.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.kidsconnect.domain.model.Activity;
import com.kidsconnect.domain.model.ParameterCriteria;

public class PojoCriteriaVisitorTest {

    private PojoCriteriaVisitor<Activity> underTest;

    private static final String Q = "q";
    private static final String I = "i";
    private static final String BOOK = "book";
    private static final String DIST = "dist";

    private static final String[] TRUE = {"true"};
    private static final String[] FALSE = {"false"};
    private static final String[] NOT_RELEVANT = {"ignore this"};
    private static final String[] DISTANCE = {"0.5"};

    
    @Test
    public void visitByParameterCriteria(){
	
	underTest = new PojoCriteriaVisitor<Activity>();
	
	Map<String, String[]> parameters = Maps.newHashMap();
	parameters.put(BOOK, TRUE);
	parameters.put(DIST, DISTANCE);
	parameters.put(Q, NOT_RELEVANT);
	parameters.put(I, NOT_RELEVANT);

	
	ParameterCriteria<Activity> parameterCriteria = new ParameterCriteria<Activity>(parameters);
	underTest.visit(parameterCriteria);
	
	
	Map<String, String[]> emptyMap = Maps.newHashMap();
	Map<String, String[]> testMap = underTest.applyTo(emptyMap);
	
	assertEquals(testMap.size(), 2);
	assertTrue(testMap.containsKey(BOOK));
	assertTrue(testMap.containsKey(DIST));

    }
}
