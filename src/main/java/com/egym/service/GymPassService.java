package com.egym.service;

import com.egym.model.GymPass;

import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
public interface GymPassService {
    /**
     * Add new gym pass to database
     * @param gymPass new gym pass
     */
    void addGymPass(GymPass gymPass);

    /**
     * Edit existed gym pass in database
     * @param gymPass existed pass
     */
    void editGymPass(GymPass gymPass);

    /**
     * Retrieve gym pass from database by its id
     * @param id id of gym pass
     * @return appropriate gym pass
     */
    GymPass getGymPassById(int id);

    /**
     * Retrieve all gym passes from database
     * @return list of gym passes
     */
    List<GymPass> getGymPassList();

    /**
     * Delete existed gym pass from database.
     * @param gymPass existed pass
     */
    void deleteGymPass(GymPass gymPass);
}
