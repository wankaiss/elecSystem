package com.gerald.elec.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 3/17/2016.
 */
public interface ICommonDao<T> {
    /**
     * ����ʵ����
     *
     * @param enetity
     */
    void save(T enetity);

    /**
     * ����ʵ����
     *
     * @param enetity
     */
    void update(T enetity);

    /**
     *
     * @param id
     * @return
     */
    T findObjectById(Serializable id);


    void deleteObjectByids(Serializable... ids);

    void deleteObjectByColletcion(List<T> list);

    List<T> findCollectionByCondiitionNoPage(String condition, final Object [] params, Map<String, String> orderBy);
}


