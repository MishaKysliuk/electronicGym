package com.egym.contoller;

import com.egym.model.Client;
import com.egym.model.Trainer;
import com.egym.model.Workout;
import com.egym.model.converters.LocalTimeToString;
import com.egym.model.converters.StringToLocalDate;
import com.egym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MichaelMAC on 16.01.17.
 */
@Controller
@RequestMapping("/rest/clientTrainingTime")
public class ClientTrainingTimeResources {

    @Autowired
    private ClientService clientService;


    /**
     * Sends list of string to angular js part. List is created from workout time that is already chosen by other clients.
     * @param dateText date from anglar js part
     * @return list of string
     */
    @RequestMapping(value = "/disabledTime", method = RequestMethod.GET)
    public @ResponseBody List<String> getDisabledTime(@RequestBody String dateText, @AuthenticationPrincipal User activeUser){
        List<String> disabledTime = new ArrayList<String>();

        Client client = clientService.getClientByUsername(activeUser.getUsername());
        Trainer trainer = client.getTrainer();

        StringToLocalDate dateConverter = new StringToLocalDate();
        LocalDate currentDate = dateConverter.convert(dateText);

        LocalTimeToString timeConverter = new LocalTimeToString();

        for(Workout workout: trainer.getWorkouts()){
            if(workout.getWorkoutDate().equals(currentDate)){
                LocalTime beginTime = workout.getWorkoutTime();
                disabledTime.add(timeConverter.convert(beginTime));
                LocalTime endTime = beginTime.plusSeconds(workout.getWorkoutDurationInSec());
                disabledTime.add(timeConverter.convert(endTime));
            }
        }
        return disabledTime;
    }
}
