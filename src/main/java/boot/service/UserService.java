package boot.service;

import boot.model.User;

import java.util.List;

public interface UserService {
    public User getById(Integer id);

    public User getByUsername(String Username);

    public User getByUsernameAndPassword(String Username, String Password);

    public User getByEmail(String Email);

    public List<User> getByPrivilege(Integer Privilege);

    public List<User> getAll();

    public Boolean Add(User user);
}
