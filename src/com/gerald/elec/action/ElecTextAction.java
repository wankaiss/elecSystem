package com.gerald.elec.action;

import com.gerald.elec.domain.ElecText;
import com.gerald.elec.service.IElecTextService;
import com.gerald.elec.utils.BaseAction;
import com.gerald.elec.vo.ElecTextVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 3/21/2016.
 */
@Controller("elecTextAction")
@Scope(value = "prototype")
public class ElecTextAction extends BaseAction<ElecTextVO> {

    ElecTextVO elecTextVO = this.getModel();
//    ElecTextVO elecTextVO = new ElecTextVO();

    @Resource(name = IElecTextService.SERVICE_NAME)
    IElecTextService service;

//    public ElecTextVO getModel() {
//        return elecTextVO ;
//    }

    public String save(){
        Date textDate = null;
        ElecText elecText = new ElecText();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");

        try {
            textDate = format.parse(elecTextVO.getTextDate1());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        elecText.setTextDate(textDate);
        elecText.setTextName(elecTextVO.getTextName());
        elecText.setTextRemark(elecTextVO.getTextRemark());

        service.saveElecText(elecText);

        System.out.println(this.getRequest().getAttribute("textName"));
        return "save";

    }
}
