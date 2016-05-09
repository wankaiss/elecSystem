package com.gerald.elec.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 4/6/2016.
 */
public class ElecSystemDDL implements Serializable{

    private Integer seqID;
    private String keyword;
    private Integer ddlCode;
    private String ddlName;

    public ElecSystemDDL() {
    }

    public ElecSystemDDL(String keyword) {
        this.keyword = keyword;
    }

    public Integer getSeqID() {
        return seqID;
    }

    public void setSeqID(Integer seqID) {
        this.seqID = seqID;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getDdlCode() {
        return ddlCode;
    }

    public void setDdlCode(Integer ddlCode) {
        this.ddlCode = ddlCode;
    }

    public String getDdlName() {
        return ddlName;
    }

    public void setDdlName(String ddlName) {
        this.ddlName = ddlName;
    }

    /**�ǳ־û�javabean������*/
    //��������
    private String keywordname;
    /**
     * �����ж�ִ�е�ҵ���ʶ
     * add����ʱ�����桿��ʾ�����е������Ͻ��б༭���޸�
     * new����ʱ�����桿��ʾ����һ����������
     */
    private String typeflag;

    //�������ֵ������
    private String [] itemname;

    public String getKeywordname() {
        return keywordname;
    }

    public void setKeywordname(String keywordname) {
        this.keywordname = keywordname;
    }

    public String getTypeflag() {
        return typeflag;
    }

    public void setTypeflag(String typeflag) {
        this.typeflag = typeflag;
    }

    public String[] getItemname() {
        return itemname;
    }

    public void setItemname(String[] itemname) {
        this.itemname = itemname;
    }
}
