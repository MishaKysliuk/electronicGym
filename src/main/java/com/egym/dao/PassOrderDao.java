package com.egym.dao;

import com.egym.model.PassOrder;

/**
 * Created by MichaelMAC on 12.01.17.
 */
public interface PassOrderDao {

    /**
     * Add new pass order to database. Payment record is also saved in db.
     * @param passOrder new pass order
     */
    void addPassOrder(PassOrder passOrder);

}
