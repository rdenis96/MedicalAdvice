
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
public class HistoryUserController { //DE VERIFICAT/COMPLETAT

    @Autowired
    HistoryUserService historyUserService;

    @RequestMapping(value = "history",method = RequestMethod.GET)
    public String loadHistory() {
        return "HistoryUser";
    }

    @RequestMapping(value = "getHistoryList", method = RequestMethod.GET, produces = "application/json")
    public String getHistoryList(){
        List<HistoryUser> symptoms = historyUserService.getByUserId(1);

        System.out.println("VRSAMOR");
        System.out.println(new Gson().toJson(symptoms));

        return new Gson().toJson(symptoms);
    }

}
