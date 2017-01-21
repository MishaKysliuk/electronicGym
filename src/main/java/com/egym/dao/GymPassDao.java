package com.egym.dao;

import com.egym.model.GymPass;

import java.util.List;

/**
 * Created by MichaelMAC on 07.01.17.
 */
public interface GymPassDao {
    void addGymPass(GymPass gymPass);

    void editGymPass(GymPass gymPass);

    GymPass getGymPassById(int id);

    List<GymPass> getGymPassList();

    void deleteGymPass(GymPass gymPass);
}
