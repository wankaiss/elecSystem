package com.gerald.elec.dao.impl;

import com.gerald.elec.dao.IElecCommonMsgContentDao;
import com.gerald.elec.domain.ElecCommonMsgContent;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 3/29/2016.
 */
@Repository(value = IElecCommonMsgContentDao.SERVICE_NAME)
public class ElecCommonMsgContentDaoImpl extends CommonDaoImpl<ElecCommonMsgContent> implements IElecCommonMsgContentDao {

}
