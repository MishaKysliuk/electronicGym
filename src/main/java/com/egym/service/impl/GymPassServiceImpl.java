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

    /**
     * Add new gym pass to database
     * @param gymPass new gym pass
     */
    public void addGymPass(GymPass gymPass) {
        gymPassDao.addGymPass(gymPass);
    }

    /**
     * Edit existed gym pass in database
     * @param gymPass existed pass
     */
    public void editGymPass(GymPass gymPass) {
        gymPassDao.editGymPass(gymPass);
    }

    /**
     * Retrieve gym pass from database by its id
     * @param id id of gym pass
     * @return appropriate gym pass
     */
    public GymPass getGymPassById(int id) {
        return gymPassDao.getGymPassById(id);
    }

    /**
     * Retrieve all gym passes from database
     * @return list of gym passes
     */
    public List<GymPass> getGymPassList() {
        return gymPassDao.getGymPassList();
    }

    /**
     * Delete existed gym pass from database.
     * @param gymPass existed pass
     */
    public void deleteGymPass(GymPass gymPass) {
        gymPassDao.deleteGymPass(gymPass);
    }
}
