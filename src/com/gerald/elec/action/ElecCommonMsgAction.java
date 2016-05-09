package com.gerald.elec.action;

import com.gerald.elec.domain.ElecCommonMsg;
import com.gerald.elec.service.IElecCommonMsgService;
import com.gerald.elec.utils.BaseAction;
import com.gerald.elec.utils.ValueUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Administrator on 3/28/2016.
 */
@Controller(value = "elecCommonMsgAction")
@Scope(value = "prototype")
public class ElecCommonMsgAction extends BaseAction<ElecCommonMsg> {

    ElecCommonMsg elecCommonMsg = this.getModel();

    @Resource(name = IElecCommonMsgService.SERVICE_NAME)
    private IElecCommonMsgService service;

    public String home() {

        ElecCommonMsg elecCommonMsg = service.find();

        ValueUtil.pushValueStack(elecCommonMsg);

        return "home";
    }

    public String savePending() {

        service.update(elecCommonMsg);
        return "savePending";
    }

    /**
     *
     * @return
     */
    public String actingView() {

        ElecCommonMsg elecCommonMsg = service.find();
        ValueUtil.pushValueStack(elecCommonMsg);

        return "actingView";
    }
}
