package com.gerald.junit;

import com.gerald.elec.dao.IElecTextDao;
import com.gerald.elec.domain.ElecText;
import com.gerald.elec.service.IElecTextService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 3/21/2016.
 */
public class ServiceTest {

    @Test
    public void testService() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        IElecTextService service = (IElecTextService) applicationContext.getBean(IElecTextService.SERVICE_NAME);

        ElecText elecText = new ElecText();
        elecText.setTextName("zhangcuishan");
        elecText.setTextDate(new Date());
        elecText.setTextRemark("xiaozhang");

        service.saveElecText(elecText);

    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IElecTextService service = (IElecTextService) applicationContext.getBean(IElecTextService.SERVICE_NAME);

        ElecText elecText = new ElecText();
        elecText.setTextID("4082a87453837dfa0153837dfef30001");
        elecText.setTextName("test update Name!");
        elecText.setTextDate(new Date());
        elecText.setTextRemark("test update remark!");

        service.update(elecText);
    }

    @Test
    public void findObjectById() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IElecTextDao service = (IElecTextDao) applicationContext.getBean(IElecTextDao.SERVICE_NAME);

        Serializable id = "4082a87453837dfa0153837dfef30001";
        ElecText elecText1 = service.findObjectById(id);

        System.out.println("name:" + elecText1.getTextName() + "; nameRemark:" + elecText1.getTextRemark());
    }

    @Test
    public void deleteObjectByIds() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IElecTextDao textDao = (IElecTextDao) applicationContext.getBean(IElecTextDao.SERVICE_NAME);

        Serializable id1 = "4082a8755396fbd4015396fbd7850001";
        Serializable id2 = "4082a8745383ec7a0153840bddc00001";

        Serializable ids[] = {"4082a8755396fbd4015396fbd7850001", "4082a8745383ec7a0153840bddc00001"};
        textDao.deleteObjectByids(ids);
    }

    @Test
    public void deleteObjectByCollection() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IElecTextDao elecTextDao = (IElecTextDao) applicationContext.getBean(IElecTextDao.SERVICE_NAME);

        List<ElecText> list = new ArrayList<ElecText>();

        ElecText elecText1 = new ElecText();
        elecText1.setTextID("4082a87553a283e00153a283e4950001");
        ElecText elecText2 = new ElecText();
        elecText2.setTextID("4082a87553a283900153a28394620001");
        ElecText elecText3 = new ElecText();
        elecText3.setTextID("4082a875539c4b0a01539c5482770001");

        list.add(elecText1);
        list.add(elecText2);
        list.add(elecText3);

        elecTextDao.deleteObjectByColletcion(list);
    }

    @Test
    public void findCollectionByConditionNoPage() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IElecTextService service = (IElecTextService) applicationContext.getBean(IElecTextService.SERVICE_NAME);

        ElecText elecText = new ElecText();

        elecText.setTextName("zhang");
        elecText.setTextRemark("zhang");

        List<ElecText> list = service.findCollectionByConditionNoPage(elecText);

        for (ElecText elecTexts : list) {
            System.out.println("name:" + elecTexts.getTextName() + "; remark:" + elecTexts.getTextRemark());
        }
    }
}
