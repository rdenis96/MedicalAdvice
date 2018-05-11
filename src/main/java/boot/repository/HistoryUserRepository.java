package boot.repository;

import boot.model.HistoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryUserRepository extends JpaRepository<HistoryUser,Integer> {

    public HistoryUser getById(Integer id);

    public List<HistoryUser> getByUsername(String username);

}
