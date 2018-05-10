package boot.service;

import boot.model.HistoryUser;
import boot.repository.HistoryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryUserServiceImpl implements HistoryUserService {

    @Autowired
    HistoryUserRepository historyUserRepository;

    @Override
    public HistoryUser getById(Integer id) {
        return historyUserRepository.getById(id);
    }

    @Override
    public List<HistoryUser> getByUserId(Integer id) {
        return historyUserRepository.getByUserId(id);
    }

    @Override
    public List<HistoryUser> getAll() {
        return historyUserRepository.findAll();
    }
}
