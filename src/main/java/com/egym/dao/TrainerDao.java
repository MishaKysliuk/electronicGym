package com.egym.dao;

import com.egym.model.Client;
import com.egym.model.Trainer;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface TrainerDao {

    void addTrainer (Trainer trainer);

    void editTrainer(Trainer trainer);

    Trainer getTrainerById (int trainerId);

    List<Trainer> getAllTrainers();

    Trainer getTrainerByUsername (String username);
    
}
