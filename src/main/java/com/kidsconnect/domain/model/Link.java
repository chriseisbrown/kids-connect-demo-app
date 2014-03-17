package com.kidsconnect.domain.model;

public class Link {

    private String url;

    public Link(String url) {
	super();
	this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
	return "Link [url=" + url + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((url == null) ? 0 : url.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Link other = (Link) obj;
	if (url == null) {
	    if (other.url != null)
		return false;
	} else if (!url.equals(other.url))
	    return false;
	return true;
    }
    
    
    
}
