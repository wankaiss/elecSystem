package com.gerald.elec.dao.impl;

import com.gerald.elec.dao.IElecSystemDDLDao;
import com.gerald.elec.domain.ElecSystemDDL;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/6/2016.
 */
@Repository(value = IElecSystemDDLDao.SERVICE_NAME)
public class ElecSystemDDLDaoImpl extends CommonDaoImpl<ElecSystemDDL> implements IElecSystemDDLDao {

    @Override
    public List<ElecSystemDDL> findDDLByDistinct() {

        /*List<ElecSystemDDL> systemDDLs = new ArrayList<ElecSystemDDL>();

        String hql = "select distinct o.keyword from ElecSystemDDL o";

        List<Object> list = this.getHibernateTemplate().find(hql);

        if (list != null && list.size() > 0) {
            for (Object o : list) {
                ElecSystemDDL systemDDL = new ElecSystemDDL();
                systemDDL.setKeyword(o.toString());
                systemDDLs.add(systemDDL);
            }
        }*/

        String hql = "SELECT DISTINCT new com.gerald.elec.domain.ElecSystemDDL(o.keyword) from ElecSystemDDL o";

        List<ElecSystemDDL> systemDDLs = this.getHibernateTemplate().find(hql);

        return systemDDLs;
    }
}
