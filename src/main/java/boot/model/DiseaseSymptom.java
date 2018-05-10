package boot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "diseases_and_symptoms")
public class DiseaseSymptom {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "disease")
    private String disease;

    @Column(name = "symptom")
    private String symptom;

    public int getId() {
        return id;
    }

    public String getDisease() {
        return disease;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiseaseSymptom that = (DiseaseSymptom) o;
        return id == that.id &&
                Objects.equals(disease, that.disease) &&
                Objects.equals(symptom, that.symptom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
