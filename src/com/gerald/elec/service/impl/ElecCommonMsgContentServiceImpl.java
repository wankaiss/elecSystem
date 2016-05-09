package com.gerald.elec.service.impl;

import com.gerald.elec.dao.IElecCommonMsgContentDao;
import com.gerald.elec.service.IElecCommonMsgContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 3/29/2016.
 */

@Service(value = IElecCommonMsgContentService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecCommonMsgContentServiceImpl implements IElecCommonMsgContentService {

    @Resource(name = IElecCommonMsgContentDao.SERVICE_NAME)
    IElecCommonMsgContentDao msgContentDao;
}
