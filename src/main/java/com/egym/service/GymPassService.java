package com.egym.service;

import com.egym.model.GymPass;

import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
public interface GymPassService {
    void addGymPass(GymPass gymPass);

    void editGymPass(GymPass gymPass);

    GymPass getGymPassById(int id);

    List<GymPass> getGymPassList();

    void deleteGymPass(GymPass gymPass);
}
