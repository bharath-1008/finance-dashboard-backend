package in.bharath.controller;

import in.bharath.entity.User;
import in.bharath.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    // Create User
    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }
}