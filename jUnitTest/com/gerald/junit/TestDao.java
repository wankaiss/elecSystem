package com.gerald.junit;

import com.gerald.elec.dao.IElecTextDao;
import com.gerald.elec.domain.ElecText;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 3/17/2016.
 */
public class TestDao {

    @Test
    public void testDao() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        IElecTextDao elecTextDao = (IElecTextDao) applicationContext.getBean(IElecTextDao.SERVICE_NAME);

        ElecText elecText = new ElecText();
        elecText.setTextName("test Dao Name!");
        elecText.setTextDate(new Date());
        elecText.setTextRemark("test Dao remark!!");

        elecTextDao.save(elecText);
    }
}
