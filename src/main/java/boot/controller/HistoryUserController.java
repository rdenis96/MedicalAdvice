
package boot.controller;

import boot.model.HistoryUser;
import boot.service.DiseaseSymptomService;
import boot.service.HistoryUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("user")
public class HistoryUserController {

    @Autowired
    HistoryUserService historyUserService;

    @RequestMapping(value = "history",method = RequestMethod.GET)
    public String loadHistory() {
        return "HistoryUser";
    }

    @RequestMapping(value = "sendHistoryList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getHistoryList(){
        List<HistoryUser> symptoms = historyUserService.getByUsername("admin");
        for(HistoryUser historyUser : symptoms)
            System.out.println("DATA TA : " + historyUser.getDate());

        //System.out.println("TESTU MEU ");
        System.out.println(new Gson().toJson(symptoms));

        return new Gson().toJson(symptoms);
    }

}
