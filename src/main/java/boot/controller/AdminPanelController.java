package boot.controller;

import boot.model.DiseaseSymptom;
import boot.service.DiseaseSymptomService;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.boot.model.naming.DatabaseIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "getDiseasesList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getDiseasesList(){
        List<String> disease = diseaseSymptomService.getAllDiseases();

        System.out.println(new Gson().toJson(disease));
        return new Gson().toJson(disease);
    }

    @RequestMapping(value = "modificaDB", method = RequestMethod.GET)
    @ResponseBody
    public int modificaDB(@RequestParam(value = "boala_select") String disease, @RequestParam(value = "simptoma_select") String symptom)
    {
        if(!disease.equals("") && !symptom.equals("")) {
            if (diseaseSymptomService.getByDiseaseAndSymptom(disease, symptom) == null) {
                diseaseSymptomService.Add(disease,symptom);
                System.out.println("RAND INSERAT:"+ disease+symptom);
                return 0;
            } else {
                diseaseSymptomService.Remove(disease,symptom);
                System.out.println("RAND sters:"+ disease+symptom);
                return 1;
            }
        }else
            return -1;
    }

    @RequestMapping(value="reloadDataFile", method = RequestMethod.GET)
    @ResponseBody
    public int reloadDataFile() throws IOException {

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

//        for(String str : rezultat)
//            System.out.println(rezultat.indexOf(str) + " -> " + str);



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

        return 1;
    }


}
