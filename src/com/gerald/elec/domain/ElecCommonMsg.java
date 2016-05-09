package com.gerald.elec.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 3/28/2016.
 */
public class ElecCommonMsg implements Serializable {

    private String comID;
    private String stationRun;
    private String devRun;
    private Date createDate;

    public String getComID() {
        return comID;
    }

    public void setComID(String comID) {
        this.comID = comID;
    }

    public String getStationRun() {
        return stationRun;
    }

    public void setStationRun(String stationRun) {
        this.stationRun = stationRun;
    }

    public String getDevRun() {
        return devRun;
    }

    public void setDevRun(String devRun) {
        this.devRun = devRun;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}