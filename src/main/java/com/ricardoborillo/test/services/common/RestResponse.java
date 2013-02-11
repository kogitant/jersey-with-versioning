package com.ricardoborillo.test.services.common;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestResponse
{
    private int version;
    private Boolean success;
    private List<?> data;
    
    public RestResponse()
    {
        this(0, true, Collections.EMPTY_LIST);
    }
    
    public RestResponse(int version, boolean success)
    {
        this(version, success, Collections.EMPTY_LIST);
    }
    
    public RestResponse(int version, boolean success, List<?> data)
    {
        this.version = version;
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public List<?> getData()
    {
        return data;
    }

    public void setData(List<?> data)
    {
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
}