package boot.controller;

import com.google.gson.Gson;

import boot.model.Symptom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loadIndex(Model model) {

        //model.addAttribute("simptome",symptoms);
        return "index";
    }

    @RequestMapping(value = "getSymptomsList", method = RequestMethod.GET)
    @ResponseBody
    public String getSymptomsList()
    {
        List<Symptom> symptoms = new ArrayList<>();
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));
        symptoms.add(new Symptom("Tuse"));
        symptoms.add(new Symptom("Febra"));
        symptoms.add(new Symptom("Diaree"));

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);
    }

    @RequestMapping(value = "selectedCheckboxes", method = RequestMethod.POST)
    public void getSelectedCheckboxes(@ModelAttribute("selCheck") String selectedValues){

        //for(String str : selectedValues)
            System.out.println(selectedValues);

    }

}
