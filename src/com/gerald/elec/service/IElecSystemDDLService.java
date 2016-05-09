package com.gerald.elec.service;

import com.gerald.elec.domain.ElecSystemDDL;

import java.util.List;

/**
 * Created by Administrator on 4/6/2016.
 */
public interface IElecSystemDDLService {
    public final static String SERVICE_NAME = "com.gerald.elec.service.impl.ElecSystemDDLServiceImpl";

    /**
     *
     * @return
     */
    List<ElecSystemDDL> findDDLByDistinct();


    List<ElecSystemDDL> findByKeyword(String keyword);

    void saveCommonMsg(ElecSystemDDL elecSystemDDL);
}
