package boot.controller;

import boot.model.DiseaseSymptom;
import boot.service.DiseaseSymptomService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    DiseaseSymptomService diseaseSymptomService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String loadIndex() {
        return "index";
    }

    @RequestMapping(value = "getSymptomsList", method = RequestMethod.GET)
    @ResponseBody
    public String getSymptomsList()
    {
        List<DiseaseSymptom> symptoms = diseaseSymptomService.getAll();

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);
    }

    @RequestMapping(value = "selectedCheckboxes")
    public void getSelectedCheckboxes(@RequestParam(value = "selCheck[]") List<String> selectedValues){
        System.out.println("VALORILE PARSATE:");
        for(String str : selectedValues)
            System.out.println("VALOARE: " + str);

    }

}
