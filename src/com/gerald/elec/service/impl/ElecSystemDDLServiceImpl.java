package com.gerald.elec.service.impl;

import com.gerald.elec.dao.IElecSystemDDLDao;
import com.gerald.elec.domain.ElecSystemDDL;
import com.gerald.elec.service.IElecSystemDDLService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 4/6/2016.
 */
@Service(value = IElecSystemDDLService.SERVICE_NAME)
public class ElecSystemDDLServiceImpl implements IElecSystemDDLService {

    @Resource(name = IElecSystemDDLDao.SERVICE_NAME)
    private IElecSystemDDLDao dao;

    @Override
    public List<ElecSystemDDL> findDDLByDistinct() {

        List<ElecSystemDDL> list = dao.findDDLByDistinct();

        return list;
    }

    @Override
    public List<ElecSystemDDL> findByKeyword(String keyword) {

        String condition = " and o.keyword = '" + keyword + "'";
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (StringUtils.isNotBlank(keyword)) {
            map.put(" o.ddlCode", "asc");
        }
        List<ElecSystemDDL> list = dao.findCollectionByCondiitionNoPage(condition, null, map);

        return list;
    }

    @Override
    public void saveCommonMsg(ElecSystemDDL elecSystemDDL) {
        if ("new".equals(elecSystemDDL.getTypeflag())) {
            int i = 0;
            for (String s : elecSystemDDL.getItemname()) {
                ElecSystemDDL systemDDL = new ElecSystemDDL();
                systemDDL.setKeyword(elecSystemDDL.getKeywordname());
                systemDDL.setDdlCode(i + 1);
                systemDDL.setDdlName(s);
                dao.save(systemDDL);
                i++;
            }
        } else {
            String condition = " and o.keyword =" + elecSystemDDL.getKeyword();
            List<ElecSystemDDL> list = dao.findCollectionByCondiitionNoPage(condition, null, null);
            dao.deleteObjectByColletcion(list);
            int i = 0;
            for (String s : elecSystemDDL.getItemname()) {
                ElecSystemDDL systemDDL = new ElecSystemDDL();
                systemDDL.setKeyword(elecSystemDDL.getKeyword());
                systemDDL.setDdlCode(i + 1);
                systemDDL.setDdlName(s);
                dao.save(systemDDL);
                i++;
            }
        }
    }


}
