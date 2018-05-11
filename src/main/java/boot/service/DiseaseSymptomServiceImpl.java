package boot.service;

import boot.model.DiseaseSymptom;
import boot.repository.DiseaseSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiseaseSymptomServiceImpl implements DiseaseSymptomService {
    @Autowired
    DiseaseSymptomRepository diseaseSymptomRepository;

    @Override
    public DiseaseSymptom getByID(Integer Id) {
        return diseaseSymptomRepository.getById(Id);
    }

    @Override
    public List<DiseaseSymptom> getBySymptom(String Symptom) {
        return diseaseSymptomRepository.getBySymptom(Symptom);
    }

    @Override
    public List<DiseaseSymptom> getByDisease(String Disease) {
        return diseaseSymptomRepository.getByDisease(Disease);
    }

    @Override
    public DiseaseSymptom getByDiseaseAndSymptom(String Disease, String Symptom) {
        return diseaseSymptomRepository.getByDiseaseAndSymptom(Disease,Symptom);
    }

    @Override
    public List<DiseaseSymptom> getAll() {
        return diseaseSymptomRepository.findAll();
    }

    @Override
    public List<String> getAllSymptoms() {
        List<DiseaseSymptom> list = diseaseSymptomRepository.findAll();
        List<String> symptom_list = new ArrayList<>();

        for(DiseaseSymptom dl : list)
            symptom_list.add(dl.getSymptom());

        Set<String> temp = new HashSet<>(symptom_list);
        symptom_list.clear();
        symptom_list.addAll(temp);

        return symptom_list;
    }

    @Override
    public List<String> getAllDiseases() {
        List<DiseaseSymptom> list = diseaseSymptomRepository.findAll();
        List<String> disease_list = new ArrayList<>();

        for(DiseaseSymptom dl : list)
            disease_list.add(dl.getDisease());

        Set<String> temp = new HashSet<>(disease_list);
        disease_list.clear();
        disease_list.addAll(temp);

        return disease_list;
    }

    @Override
    public Boolean Add(String disease, String symptom) {

        DiseaseSymptom diseaseSymptom = new DiseaseSymptom();
        diseaseSymptom.setDisease(disease);
        diseaseSymptom.setSymptom(symptom);

        try
        {
            diseaseSymptomRepository.saveAndFlush(diseaseSymptom);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public void Remove(String disease, String symptom) {
        DiseaseSymptom diseaseSymptom = diseaseSymptomRepository.getByDiseaseAndSymptom(disease,symptom);
        diseaseSymptomRepository.delete(diseaseSymptom);
    }

}
