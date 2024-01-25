package JavaApp.questionApp.controllers;

import JavaApp.questionApp.entities.User;
import JavaApp.questionApp.repos.UserRepository;
import JavaApp.questionApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService _service;
    @GetMapping
    public List<User> getAllUsers(){
        return _service.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return _service.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception
        return _service.getOneUserById(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return _service.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        _service.deleteOneUser(userId);
    }
}
