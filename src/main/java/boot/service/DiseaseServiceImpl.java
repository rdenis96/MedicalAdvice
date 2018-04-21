package boot.service;


import boot.model.Disease;
import boot.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService{

    @Autowired
    DiseaseRepository diseaseRepository;

    @Override
    public List<Disease> getAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public Disease getByName(String name) {
        return diseaseRepository.getByName(name);
    }
}
