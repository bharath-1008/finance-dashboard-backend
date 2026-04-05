package in.bharath.serviceImplementation;

import in.bharath.entity.User;
import in.bharath.repository.UserRepository;
import in.bharath.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }
}