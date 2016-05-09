package com.gerald.elec.service;

import com.gerald.elec.domain.ElecText;

import java.util.List;

/**
 * Created by Administrator on 3/21/2016.
 */
public interface IElecTextService {

    public static final String SERVICE_NAME = "com.gerald.elec.service.impl.ElecTextServiceImpl";

    /**
     * save function in service
     * @param elecText
     */
    public void saveElecText(ElecText elecText);


    void update(ElecText elecText);

    ElecText findObjectById(ElecText elecText);

    List<ElecText> findCollectionByConditionNoPage(ElecText elecText);
}
