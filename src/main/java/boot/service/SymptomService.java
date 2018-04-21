package boot.service;

import boot.model.Symptom;

import java.util.List;

public interface SymptomService {
    public List<Symptom> getAll();

    public Symptom getByName(String name);
}
