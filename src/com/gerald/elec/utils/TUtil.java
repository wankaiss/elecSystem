package com.gerald.elec.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 3/22/2016.
 */
public class TUtil {

    public static Class getEntity(Class entity) {

        ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();

        Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];

        return entityClass;
    }
}
