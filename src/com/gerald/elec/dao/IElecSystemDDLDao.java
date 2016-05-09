package com.gerald.elec.dao;

import com.gerald.elec.domain.ElecSystemDDL;

import java.util.List;

/**
 * Created by Administrator on 4/6/2016.
 */
public interface IElecSystemDDLDao extends ICommonDao<ElecSystemDDL>{

    public static final String SERVICE_NAME = "com.gerald.elec.dao.impl.ElecSystemDDLDaoImpl";

    List<ElecSystemDDL> findDDLByDistinct();
}
