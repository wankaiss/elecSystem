package com.gerald.elec.dao.impl;

import com.gerald.elec.dao.ICommonDao;
import com.gerald.elec.utils.TUtil;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 3/17/2016.
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T>{

    Class entityClass = TUtil.getEntity(this.getClass());

    @Resource(name = "sessionFactory")
    public final void setSessionFactoryDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(T enetity) {
        this.getHibernateTemplate().save(enetity);
    }

    @Override
    public void update(T enetity) {
        this.getHibernateTemplate().update(enetity);
    }

    @Override
    public T findObjectById(Serializable id) {

        return (T) this.getHibernateTemplate().get(entityClass, id);

    }

    @Override
    public void deleteObjectByids(Serializable... ids) {
        if(ids!=null && ids.length>0){
            for(Serializable id:ids){
                Object entity = this.findObjectById(id);
                this.getHibernateTemplate().delete(entity);
            }
        }
    }

    @Override
        public void deleteObjectByColletcion(List<T> list) {

        this.getHibernateTemplate().deleteAll(list);
    }

    @Override
    public List<T> findCollectionByCondiitionNoPage(String condition, Object[] params, Map<String, String> orderBy) {
        StringBuffer sql = new StringBuffer("from " + entityClass.getSimpleName() + " o where 1 = 1 ");
        sql.append(condition);
        String orderbyCondition = this.getOrderby(orderBy);
        sql.append(orderbyCondition);
        return this.getHibernateTemplate().find(sql.toString(), params);
    }

    private String getOrderby(Map<String, String> orderBy) {

        StringBuffer buffer = new StringBuffer();
        if (orderBy != null && orderBy.size() > 0) {
            buffer.append(" order by ");
            for (Map.Entry<String, String> entry : orderBy.entrySet()) {
                buffer.append(entry.getKey() + " " + entry.getValue() + ",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
        }

        return buffer.toString();
    }
}
