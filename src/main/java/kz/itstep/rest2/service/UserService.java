package kz.itstep.rest2.service;

import kz.itstep.rest2.model.User;
import kz.itstep.rest2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null; // exception handling обработка исключений
        }
//        return user.orElse(null); // можно и так написать
    }

    public User createUser(User user) {
        if (user != null)
            return userRepository.save(user);
        return null; // exception handling обработка исключений
    }

    public User updateUser(Long userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        }
        return null; // exception handling обработка исключений
    }
    public void deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent())
            userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
