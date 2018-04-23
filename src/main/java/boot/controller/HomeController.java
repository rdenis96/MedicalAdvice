package boot.controller;

import com.google.gson.Gson;

import boot.model.Symptom;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loadIndex(Model model) {

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

    @RequestMapping(value = "selectedCheckboxes")
    public void getSelectedCheckboxes(@RequestParam(value = "selCheck[]") List<String> selectedValues){
        System.out.println("VALORILE PARSATE:");
        for(String str : selectedValues)
            System.out.println("VALOARE: " + str);

    }

}
