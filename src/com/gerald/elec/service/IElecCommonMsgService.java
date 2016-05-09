package com.gerald.elec.service;

import com.gerald.elec.domain.ElecCommonMsg;

/**
 * Created by Administrator on 3/28/2016.
 */
public interface IElecCommonMsgService {
    public static final String SERVICE_NAME = "com.gerald.elec.service.impl.ElecCommonMsgServiceImpl";

    ElecCommonMsg find();

    void update(ElecCommonMsg elecCommonMsg);
}
