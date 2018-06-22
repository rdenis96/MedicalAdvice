package boot.service;

import boot.model.User;
import boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByUsername(String Username) {
        return userRepository.getByUsername(Username);
    }

    @Override
    public User getByUsernameAndPassword(String Username, String Password) {
        return userRepository.getByUsernameAndPassword(Username,Password);
    }

    @Override
    public User getByEmail(String Email) {
        return userRepository.getByEmail(Email);
    }

    @Override
    public List<User> getByPrivilege(Integer Privilege) {
        return userRepository.getByPrivilege(Privilege);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean Add(User user) {
        try{
            userRepository.saveAndFlush(user);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
