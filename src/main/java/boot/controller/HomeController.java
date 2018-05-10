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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getSelectedCheckboxes(@RequestParam("username") String username, @RequestParam("diseases") List<String> diseases, @RequestParam("symptoms") List<String> symptoms){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime data_curenta = LocalDateTime.now();

        //CEVA PT ADD

    }

}
