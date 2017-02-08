package com.egym.service.impl;

import com.egym.dao.TrainerDao;
import com.egym.model.Trainer;
import com.egym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao trainerDao;

    /**
     * Add new trainer to database. New user and authority are also added to db.
     * @param trainer new trainer
     */
    public void addTrainer(Trainer trainer) {
        trainerDao.addTrainer(trainer);
    }

    /**
     * Edit existed trainer into database
     * @param trainer existed trainer
     */
    public void editTrainer(Trainer trainer) {
        trainerDao.editTrainer(trainer);
    }

    /**
     * Retrieve trainer from database by his id
     * @param trainerId trainer id
     * @return appropriate trainer
     */
    public Trainer getTrainerById(int trainerId) {
        return trainerDao.getTrainerById(trainerId);
    }

    /**
     * Retrieve all trainers from database
     * @return list of trainers
     */
    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainers();
    }

    /**
     * Retrieve trainer from database by his username
     * @param username trainer username
     * @return appropriate trainer
     */
    public Trainer getTrainerByUsername(String username) {
        return trainerDao.getTrainerByUsername(username);
    }
}
