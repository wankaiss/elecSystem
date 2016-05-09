package com.gerald.elec.dao.impl;

import com.gerald.elec.dao.IElecCommonMsgDao;
import com.gerald.elec.domain.ElecCommonMsg;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 3/28/2016.
 */
@Repository(value = IElecCommonMsgDao.SERVICE_NAME)
public class ElecCommonMsgDaoImpl extends CommonDaoImpl<ElecCommonMsg> implements IElecCommonMsgDao {
}
