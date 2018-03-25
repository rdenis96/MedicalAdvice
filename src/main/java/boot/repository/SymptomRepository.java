package boot.repository;

import boot.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom,String>{
    public Symptom getByName(String name);
}
