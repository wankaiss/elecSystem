package com.gerald.junit;

import com.gerald.elec.domain.ElecText;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Administrator on 3/17/2016.
 */
public class JUnitTest {
    @Test
    public void testSave() {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ElecText elecText = new ElecText();
        elecText.setTextName("hibernate");
        elecText.setTextDate(new Date());
        elecText.setTextRemark("This is hibernate test");

        session.save(elecText);

        transaction.commit();
        session.close();
    }
}
