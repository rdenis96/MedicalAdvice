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

    @RequestMapping(value = "getBoliList", method = RequestMethod.GET)
    @ResponseBody
    public String getBoliList(){
        //TREBUIE NISTE FUNCTII CARE SA RETURNEZE DOAR BOLILE SI DOAR SIMPTOMELE
       /* List<DiseaseSymptom> diseases = diseaseSymptomService.getBoli();

        System.out.println(new Gson().toJson(diseases));
        return new Gson().toJson(diseases);
        */return "";
    }

    @RequestMapping(value = "getSimptomeList", method = RequestMethod.GET)
    @ResponseBody
    public String getSimptomeList()
    {
        /*List<DiseaseSymptom> symptoms = diseaseSymptomService.getSimptome();

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);
        */ return "";
    }

}
