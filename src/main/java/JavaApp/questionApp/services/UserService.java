package JavaApp.questionApp.services;

import JavaApp.questionApp.entities.User;
import JavaApp.questionApp.repos.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository _repository;

    public List<User> getAllUsers() {
        return _repository.findAll();
    }

    public User saveOneUser(User newUser) {
        return _repository.save(newUser);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user=_repository.findById(userId);
        if(user.isPresent()){
            User foundUser=user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            _repository.save(foundUser);
            return foundUser;
        }else{
            return null;
        }
    }

    public void deleteOneUser(Long userId) {
        _repository.deleteById(userId);
    }

    public User getOneUserById(Long userId) {
        return _repository.findById(userId).orElse(null);
    }
}
