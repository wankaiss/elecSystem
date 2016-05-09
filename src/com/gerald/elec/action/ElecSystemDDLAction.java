package com.gerald.elec.action;

import com.gerald.elec.domain.ElecSystemDDL;
import com.gerald.elec.service.IElecSystemDDLService;
import com.gerald.elec.utils.BaseAction;
import com.gerald.elec.utils.ValueUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 4/6/2016.
 */
@Controller(value = "elecSystemDDLAction")
@Scope(value = "prototype")
public class ElecSystemDDLAction extends BaseAction<ElecSystemDDL> {

    ElecSystemDDL elecSystemDDL = this.getModel();

    @Resource(name = IElecSystemDDLService.SERVICE_NAME)
    IElecSystemDDLService service;

    public String home() {

        List<ElecSystemDDL> list = service.findDDLByDistinct();

        request.setAttribute("list", list);

        return "home";
    }

    public String edit() {

        String keyword = elecSystemDDL.getKeyword();
        System.out.println(keyword);
        String saveItem = request.getParameter("saveitem");
        System.out.println(saveItem);
        List<ElecSystemDDL> list = service.findByKeyword(keyword);

        this.request.setAttribute("list", list);
        return "edit";
    }

    public String save() {
        service.saveCommonMsg(elecSystemDDL);
        return "save";
    }

    /**
     * RunListen module
     * @return
     * @throws IOException
     */
    public String progressBar() throws IOException {
        Double percent = (Double) this.request.getSession().getAttribute("percent");
        String res = "";

        if (percent != null) {
            int percentInt = (int) Math.rint(percent);
            res = "percent" + percentInt + "percent";

        } else {
            res = "<percent>" + 100 + "</percent>";
        }
        PrintWriter out = this.response.getWriter();
        this.response.setContentType("text/xml");
        this.response.setHeader("Cache-Control", "no-cache");
        out.print("<response>");
        out.print(res);
        out.print("</response>");
        out.close();
        return null;
    }

}
