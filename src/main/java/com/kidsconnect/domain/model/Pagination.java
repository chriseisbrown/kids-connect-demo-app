package com.kidsconnect.domain.model;

public class Pagination
{
    private long totalResultsSize;
    private long batchSize;
    private long batchIndex;

    public static Pagination empty()
    {
        return new Pagination(0, 0, 0);
    }

    public Pagination(long totalResultsSize, long batchSize, long batchIndex)
    {
        this.totalResultsSize = totalResultsSize;
        this.batchSize = batchSize;
        this.batchIndex = batchIndex;
    }

    public long getTotalResultsSize()
    {
        return totalResultsSize;
    }

    public long getBatchSize()
    {
        return batchSize;
    }

    public long getBatchIndex()
    {
        return batchIndex;
    }

    @Override
    public String toString() {
	return "Pagination [totalResultsSize=" + totalResultsSize
		+ ", batchSize=" + batchSize + ", batchIndex=" + batchIndex
		+ "]";
    }
    
}
