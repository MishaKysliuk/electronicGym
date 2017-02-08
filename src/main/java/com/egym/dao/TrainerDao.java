package com.egym.dao;

import com.egym.model.Client;
import com.egym.model.Trainer;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface TrainerDao {

    /**
     * Add new trainer to database. New user and authority are also added to db.
     * @param trainer new trainer
     */
    void addTrainer (Trainer trainer);

    /**
     * Edit existed trainer into database
     * @param trainer existed trainer
     */
    void editTrainer(Trainer trainer);

    /**
     * Retrieve trainer from database by his id
     * @param trainerId trainer id
     * @return appropriate trainer
     */
    Trainer getTrainerById (int trainerId);

    /**
     * Retrieve all trainers from database
     * @return list of trainers
     */
    List<Trainer> getAllTrainers();

    /**
     * Retrieve trainer from database by his username
     * @param username trainer username
     * @return appropriate trainer
     */
    Trainer getTrainerByUsername (String username);
    
}
