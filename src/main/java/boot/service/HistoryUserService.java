package boot.service;

import boot.model.HistoryUser;

import java.util.List;

public interface HistoryUserService {

    public HistoryUser getById(Integer id);

    public List<HistoryUser> getByUserid(Integer id);

    public List<HistoryUser> getAll();

}
