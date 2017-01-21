package com.egym.dao.impl;

import com.egym.dao.PassOrderDao;
import com.egym.model.PassOrder;
import com.egym.model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MichaelMAC on 12.01.17.
 */
@Repository
@Transactional
public class PassOrderDaoImpl implements PassOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPassOrder(PassOrder passOrder) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment = passOrder.getPayment();
        session.saveOrUpdate(payment);
        session.saveOrUpdate(passOrder);
        session.flush();
    }
}
