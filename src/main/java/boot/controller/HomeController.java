package boot.controller;

import boot.model.DiseaseSymptom;
import boot.model.User;
import boot.service.DiseaseSymptomService;
import boot.service.UserService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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

    @RequestMapping(value = "selectedCheckboxes")
    public void getSelectedCheckboxes(@RequestParam(value = "selCheck[]") List<String> selectedValues){
        //System.out.println("VALORILE PARSATE:");
        for(String str : selectedValues)
            System.out.println("VALOARE: " + str);
    }

    @RequestMapping(value = "ceva")
    public void getCeva() throws IOException { //functia asta ar trebui sa returneze un json cu m spunea razvan. E POSIBIL SA NU MEARGA

        List<String> diseasesList = diseaseSymptomService.getAllDiseases();
        List<String> symptomsList = diseaseSymptomService.getAllSymptoms();
        List<DiseaseSymptom> diseaseSymptomList = diseaseSymptomService.getAll();
        Map<String,ArrayList<String>> dataSets = new HashMap<>();
        for(DiseaseSymptom diseaseSymptom : diseaseSymptomList)
        {

            if(!dataSets.containsKey(diseaseSymptom.getDisease()))
            {
                ArrayList<String> first = new ArrayList<>();
                first.add(diseaseSymptom.getSymptom());
                dataSets.put(diseaseSymptom.getDisease(), first);
            }
            else
                dataSets.get(diseaseSymptom.getDisease()).add(diseaseSymptom.getSymptom());

        }

        ArrayList<String> rezultat = new ArrayList<>();

        for(String disease: dataSets.keySet())
        {
            for(String symptom : dataSets.get(disease))
            {
                String query = "{";
                for(String sy : symptomsList)
                {
                    int c;
                    if(dataSets.get(disease).contains(sy) && sy.equals(symptom))
                        c = 0;
                    else if(dataSets.get(disease).contains(sy) && !sy.equals(symptom))
                        c = 1;
                    else
                        c = 0;
                    query = query + "\"" + sy + "\":" + "\"" + c + "\",";
                }
                query = query + "\"disease\":" + "\"" + disease + "\",";
                query = query.substring(0, query.length() - 1);
                query = query + "},";

                rezultat.add(query);
            }
            String query = "{";
            for(String sy : symptomsList)
            {
                int c;
                if(dataSets.get(disease).contains(sy))
                    c = 1;
                else
                    c = 0;
                query = query + "\"" + sy + "\":" + "\"" + c + "\",";

            }
            query = query + "\"disease\":" + "\"" + disease + "\",";
            query = query.substring(0, query.length() - 1);
            query = query + "},";
            rezultat.add(query);
        }
        String first = "var examples = [" + rezultat.get(0);
        rezultat.set(0,first);

        String last = rezultat.get(rezultat.size() - 1).substring(0, rezultat.get(rezultat.size() - 1).length() - 1) + "]; \n examples = _(examples);";
        rezultat.remove(rezultat.size() - 1);
        rezultat.add(last);

        for(String str : rezultat)
            System.out.println(rezultat.indexOf(str) + " -> " + str);



        File file4 = new File("src/main/resources/public/js/examples.js");
        RandomAccessFile stream = new RandomAccessFile(file4, "rw");
        FileChannel channel = stream.getChannel();

        for(String str : rezultat)
        {
            str = str + "\n";
            byte[] strBytes = str.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
        }

        stream.close();
        channel.close();
    }

}
