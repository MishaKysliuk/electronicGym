package com.egym.service.impl;

import com.egym.dao.PassOrderDao;
import com.egym.model.PassOrder;
import com.egym.service.PassOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MichaelMAC on 12.01.17.
 */
@Service
public class PassOrderServiceImpl implements PassOrderService {

    @Autowired
    private PassOrderDao passOrderDao;

    public void addPassOrder(PassOrder passOrder) {
        passOrderDao.addPassOrder(passOrder);
    }
}
