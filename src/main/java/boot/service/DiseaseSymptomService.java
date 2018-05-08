package boot.service;

import boot.model.DiseaseSymptom;

import java.util.List;

public interface DiseaseSymptomService {
    public DiseaseSymptom getByID(Integer Id);

    public List<DiseaseSymptom> getBySymptom(String Symptom);

    public List<DiseaseSymptom> getByDisease(String Disease);

    public DiseaseSymptom getByDiseaseAndSymptom(String Disease, String Symptom);

    public List<DiseaseSymptom> getAll();

    public List<String> getAllSymptoms();

    public List<String> getAllDiseases();

    public Boolean Add(DiseaseSymptom diseaseSymptom);
}
