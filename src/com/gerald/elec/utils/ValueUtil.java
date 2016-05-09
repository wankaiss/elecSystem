package com.gerald.elec.utils;

import com.gerald.elec.domain.ElecCommonMsg;
import org.apache.struts2.ServletActionContext;

/**
 * Created by Administrator on 3/28/2016.
 */
public class ValueUtil {

    public static void pushValueStack(Object object) {
        ServletActionContext.getContext().getValueStack().push(object);
    }
}
