package boot.controller;

import boot.model.DiseaseSymptom;
import boot.model.HistoryUser;
import boot.model.User;
import boot.service.DiseaseSymptomService;
import boot.service.HistoryUserService;
import boot.service.UserService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    DiseaseSymptomService diseaseSymptomService;

    @Autowired
    UserService userService;

    @Autowired
    HistoryUserService historyUser;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String loadIndex() {
        return "index";
    }

    @RequestMapping(value = "getSymptomsList", method = RequestMethod.GET)
    @ResponseBody
    public String getSymptomsList()
    {
        List<String> symptoms = diseaseSymptomService.getAllSymptoms();

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);
    }

    @RequestMapping(value = "checkAdmin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public int validateLogin(@RequestParam("username") String username){

        System.out.println("USERU BA! " + username + "--");
        User user = userService.getByUsername(username);
        if(user != null)
        {
            if(user.getPrivilege()==1)
                return 2;
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "updateHistory")
    public void getSelectedCheckboxes(@RequestParam("username") String username, @RequestParam("diseases[]") List<String> diseases, @RequestParam("symptoms[]") List<String> symptoms) {

        Date dt = Calendar.getInstance().getTime();

        HistoryUser history = new HistoryUser();
        history.setDate(dt);

        String diseasesString = "";
        for(String str : diseases)
            diseasesString = diseasesString + str + ", ";
        System.out.println("BOLILELE BA: " + diseasesString);
        history.setDiseases(diseasesString);

        String symptomsString = "";
        for(String str : symptoms)
            symptomsString = symptomsString + str + ", ";
        System.out.println("SIMPTOMELE BA: " + symptomsString);
        history.setSymptoms(symptomsString);

        history.setUsername(username);

        historyUser.Add(history);

        //CEVA PT ADD
    }





}
