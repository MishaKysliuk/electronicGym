package com.egym.service;

import com.egym.model.Trainer;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface TrainerService {

    void addTrainer (Trainer trainer);

    void editTrainer(Trainer trainer);

    Trainer getTrainerById (int trainerId);

    List<Trainer> getAllTrainers();

    Trainer getTrainerByUsername (String username);

}
