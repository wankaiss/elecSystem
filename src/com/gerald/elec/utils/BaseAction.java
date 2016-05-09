package com.gerald.elec.utils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 3/21/2016.
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware, ServletResponseAware {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    T entity;

    public BaseAction() {

        Class entityClass = TUtil.getEntity(this.getClass());

        try {

            entity = (T) entityClass.newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public T getModel() {

        return entity;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {

        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {

        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {

        return response;
    }
}
