package com.gerald.elec.service.impl;

import com.gerald.elec.dao.IElecTextDao;
import com.gerald.elec.domain.ElecText;
import com.gerald.elec.service.IElecTextService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Administrator on 3/21/2016.
 */
@Service(IElecTextService.SERVICE_NAME)
public class ElecTextServiceImpl implements IElecTextService {

    @Resource(name = IElecTextDao.SERVICE_NAME)
    private IElecTextDao iElecTextDao;


    @Override
    public void saveElecText(ElecText elecText) {
        iElecTextDao.save(elecText);

    }

    @Override
    public void update(ElecText elecText) {
        iElecTextDao.update(elecText);
    }

    @Override
    public ElecText findObjectById(ElecText elecText) {

        Serializable id = elecText.getTextID();

       // elecText = iElecTextDao.findObjectById(id);

        return elecText;
    }

    @Override
    public List<ElecText> findCollectionByConditionNoPage(ElecText elecText) {

        String condition = "";
        List<Object> paramList = new ArrayList<Object>();

        if (StringUtils.isNotBlank(elecText.getTextName())) {
            condition += " and o.textName like ?";
            paramList.add("%" + elecText.getTextName() + "%");
        }

        if (StringUtils.isNotBlank(elecText.getTextRemark())) {
            condition += " and o.textRemark like ?";
            paramList.add("%" + elecText.getTextRemark() + "%");
        }

        Object[] params = paramList.toArray();

        HashMap<String, String> orderBy = new LinkedHashMap<String, String>();

        orderBy.put(" o.textDate", "asc");
        orderBy.put(" o.textName", "desc");

        List<ElecText> list = iElecTextDao.findCollectionByCondiitionNoPage(condition, params, orderBy);
        return list;
    }
}
