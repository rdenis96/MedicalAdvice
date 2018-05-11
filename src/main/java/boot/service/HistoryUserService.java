package boot.service;

import boot.model.HistoryUser;

import java.util.List;

public interface HistoryUserService {

    public HistoryUser getById(Integer id);

    public List<HistoryUser> getByUsername(String username);

    public List<HistoryUser> getAll();

}
