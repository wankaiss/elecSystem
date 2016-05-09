package com.gerald.elec.dao.impl;

import com.gerald.elec.dao.IElecTextDao;
import com.gerald.elec.domain.ElecText;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 3/17/2016.
 */
@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl extends CommonDaoImpl<ElecText> implements IElecTextDao {

}
