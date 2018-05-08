package boot.controller;

import boot.model.DiseaseSymptom;
import boot.service.DiseaseSymptomService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminPanelController {

    @Autowired
    DiseaseSymptomService diseaseSymptomService;

    @RequestMapping(value = "panel",method = RequestMethod.GET)
    public String loadAdmin() {
        return "AdminPanel";
    }

    @RequestMapping(value = "getSimptomsList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSimptomsList(){

        List<String> symptoms = diseaseSymptomService.getAllSymptoms();

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);

    }

    @RequestMapping(value = "getDiseasesList", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String getDiseasesList()
    {
        List<String> disease = diseaseSymptomService.getAllDiseases();

        System.out.println(new Gson().toJson(disease));
        return new Gson().toJson(disease);
    }

}
