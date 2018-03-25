package boot.service;

import boot.model.Disease;

import java.util.List;

public interface DiseaseService {
    public List<Disease> getAll();

    public Disease getByName(String name);
}
