package boot.service;


import boot.model.Symptom;
import boot.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService{

    @Autowired
    SymptomRepository symptomRepository;

    @Override
    public List<Symptom> getAll() {
        return symptomRepository.findAll();
    }

    @Override
    public Symptom getByName(String name) {
        return symptomRepository.getByName(name);
    }
}
