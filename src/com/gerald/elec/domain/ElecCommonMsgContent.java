package com.gerald.elec.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 3/29/2016.
 */
public class ElecCommonMsgContent implements Serializable {

    private String comID;
    private String type;
    private String content;
    private int orderby;

    public String getComID() {
        return comID;
    }

    public void setComID(String comID) {
        this.comID = comID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

}
