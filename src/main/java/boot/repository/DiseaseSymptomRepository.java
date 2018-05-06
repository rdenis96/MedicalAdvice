package boot.repository;

import boot.model.DiseaseSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseSymptomRepository extends JpaRepository<DiseaseSymptom,Integer> {
    public DiseaseSymptom getById(Integer Id);

    public List<DiseaseSymptom> getBySymptom(String Symptom);

    public List<DiseaseSymptom> getByDisease(String Disease);

    public DiseaseSymptom getByDiseaseAndSymptom(String Disease, String Symptom);

}
