package com.egym.service.impl;

import com.egym.dao.GymPassDao;
import com.egym.model.GymPass;
import com.egym.service.GymPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Service
public class GymPassServiceImpl implements GymPassService{
    @Autowired
    private GymPassDao gymPassDao;

    public void addGymPass(GymPass gymPass) {
        gymPassDao.addGymPass(gymPass);
    }

    public void editGymPass(GymPass gymPass) {
        gymPassDao.editGymPass(gymPass);
    }

    public GymPass getGymPassById(int id) {
        return gymPassDao.getGymPassById(id);
    }

    public List<GymPass> getGymPassList() {
        return gymPassDao.getGymPassList();
    }

    public void deleteGymPass(GymPass gymPass) {
        gymPassDao.deleteGymPass(gymPass);
    }
}
