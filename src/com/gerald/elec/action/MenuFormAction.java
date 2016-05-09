package com.gerald.elec.action;

import com.gerald.elec.action.form.MenuForm;
import com.gerald.elec.domain.ElecCommonMsg;
import com.gerald.elec.service.IElecCommonMsgService;
import com.gerald.elec.service.IElecTextService;
import com.gerald.elec.utils.BaseAction;
import com.gerald.elec.utils.ValueUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 3/24/2016.
 */
@Controller("menuFormAction")
@Scope("prototype")
public class MenuFormAction extends BaseAction<MenuForm> {

    @Resource(name = IElecTextService.SERVICE_NAME)
    IElecTextService service;

    @Resource(name = IElecCommonMsgService.SERVICE_NAME)
    IElecCommonMsgService service1;

    public String menuHome() {

        return "menuHome";
    }

    public String title() {

        return "title";
    }

    public String left() {

        return "left";
    }


    public String change() {

        return "change";
    }

    public String loading() {

        ElecCommonMsg elecCommonMsg  = service1.find();
        ValueUtil.pushValueStack(elecCommonMsg);
        return "loading";
    }


    public String logout() {

        HttpSession session = this.getRequest().getSession();

        session.invalidate();

        return "logout";
    }

    public String alermDevice() {

        ElecCommonMsg elecCommonMsg  = service1.find();
        ValueUtil.pushValueStack(elecCommonMsg);

        return "alermDevice";
    }

    public String alermStation() {

        ElecCommonMsg elecCommonMsg  = service1.find();
        ValueUtil.pushValueStack(elecCommonMsg);
        return "alermStation";
    }
}
