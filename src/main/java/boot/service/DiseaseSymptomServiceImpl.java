package boot.service;

import boot.model.DiseaseSymptom;
import boot.repository.DiseaseSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Boolean Add(DiseaseSymptom diseaseSymptom) {
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
}
