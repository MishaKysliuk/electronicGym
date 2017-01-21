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

    public void addTrainer(Trainer trainer) {
        trainerDao.addTrainer(trainer);
    }

    public void editTrainer(Trainer trainer) {
        trainerDao.editTrainer(trainer);
    }

    public Trainer getTrainerById(int trainerId) {
        return trainerDao.getTrainerById(trainerId);
    }

    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainers();
    }

    public Trainer getTrainerByUsername(String username) {
        return trainerDao.getTrainerByUsername(username);
    }
}
