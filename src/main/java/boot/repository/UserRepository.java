package boot.repository;

import boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User getById(Integer id);

    public User getByUsername(String Username);

    public User getByUsernameAndPassword(String Username, String Password);

    public User getByEmail(String Email);

    public List<User> getByPrivilege(Integer Privilege);


}
