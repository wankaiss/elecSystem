package com.gerald.elec.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 3/17/2016.
 */
public class ElecText implements Serializable {
    /**
     * CREATE TABLE Elec_Text(
     textID VARCHAR(50) NOT NULL PRIMARY KEY,
     textName VARCHAR(50),
     textDate DATETIME,
     textRemark VARCHAR(500)
     )
     */
    private String textID;
    private String textName;
    private Date textDate;
    private String textRemark;

    public String getTextID() {
        return textID;
    }

    public void setTextID(String textID) {
        this.textID = textID;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public Date getTextDate() {
        return textDate;
    }

    public void setTextDate(Date textDate) {
        this.textDate = textDate;
    }

    public String getTextRemark() {
        return textRemark;
    }

    public void setTextRemark(String textRemark) {
        this.textRemark = textRemark;
    }
}
