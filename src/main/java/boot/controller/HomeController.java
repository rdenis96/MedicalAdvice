package boot.controller;

import boot.model.DiseaseSymptom;
import boot.service.DiseaseSymptomService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> symptoms = diseaseSymptomService.getAllSymptoms();

        System.out.println(new Gson().toJson(symptoms));
        return new Gson().toJson(symptoms);
    }

    @RequestMapping(value = "selectedCheckboxes")
    public void getSelectedCheckboxes(@RequestParam(value = "selCheck[]") List<String> selectedValues){
        //System.out.println("VALORILE PARSATE:");
        for(String str : selectedValues)
            System.out.println("VALOARE: " + str);
    }

    public String getCeva(){ //functia asta ar trebui sa returneze un json cu m spunea razvan. E POSIBIL SA NU MEARGA

        List<String> lista_boli = diseaseSymptomService.getAllDiseases();
        List<String> lista_simptome = diseaseSymptomService.getAllSymptoms();
        List<DiseaseSymptom> perechi_boala_simptome = new ArrayList<>();
        List<String> lista_simptome_pt_o_boala = new ArrayList<>();

        Map<String, List<String>> boala_cu_simptomele_ei = new HashMap<>();

        for(String str:lista_boli){
            perechi_boala_simptome=diseaseSymptomService.getByDisease(str);
            for(DiseaseSymptom ds:perechi_boala_simptome){
                lista_simptome_pt_o_boala.add(ds.getSymptom());
            }
            boala_cu_simptomele_ei.put(str,lista_simptome_pt_o_boala);
            lista_simptome_pt_o_boala.clear();
        }

        int c;
        String rezultat = "[";

        for(String boala : lista_boli){
            for(String simptoma_boala : boala_cu_simptomele_ei.get(boala)){
                rezultat = rezultat + "{";
                for(String simptoma : lista_simptome) {
                    if(boala_cu_simptomele_ei.get(boala).contains(simptoma) && !simptoma.equals(simptoma_boala))
                        c=1;
                    else
                        c=0;
                    rezultat = rezultat + "\"" + simptoma + "\":" + "\"" + c + "\",";
                }
                rezultat = rezultat + "\"disease\":" + "\"" + boala + "\",";
                rezultat = rezultat.substring(0, rezultat.length()-1);
                rezultat = rezultat + "},";
            }
            rezultat = rezultat + "{";
            for(String simptoma:lista_simptome){
                if(boala_cu_simptomele_ei.get(boala).contains(simptoma))
                    c=1;
                else
                    c=1;
                rezultat = rezultat + "\"" + simptoma + "\":" + "\"" + c + "\",";
            }
            rezultat = rezultat + "\"disease\":" + "\"" + boala + "\",";
            rezultat = rezultat.substring(0, rezultat.length()-1);
            rezultat = rezultat + "},";
        }
        rezultat=rezultat.substring(0,rezultat.length()-1);
        rezultat = rezultat + "]";

        return rezultat;
    }

}
