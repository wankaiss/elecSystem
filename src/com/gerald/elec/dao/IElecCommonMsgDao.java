package com.gerald.elec.dao;

import com.gerald.elec.dao.ICommonDao;
import com.gerald.elec.domain.ElecCommonMsg;

/**
 * Created by Administrator on 3/28/2016.
 */
public interface IElecCommonMsgDao extends ICommonDao<ElecCommonMsg> {

    public static final String SERVICE_NAME="com.gerald.elec.dao.impl.ElecCommonMsgDaoImpl";

}
