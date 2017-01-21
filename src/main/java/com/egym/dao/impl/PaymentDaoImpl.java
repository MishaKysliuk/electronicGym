package com.egym.dao.impl;

import com.egym.dao.PaymentDao;
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
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPayment(Payment payment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(payment);
        session.flush();

    }
}
