package kz.itstep.rest2.service;

import kz.itstep.rest2.exceptions.UserExistException;
import kz.itstep.rest2.exceptions.UserNotFoundException;
import kz.itstep.rest2.model.User;
import kz.itstep.rest2.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    @SneakyThrows
    public User getUserByUsername(String username){
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UserNotFoundException("User with username: " + username + " not found.");
        }
        return user;
    }
    public User createUser(User user) {
        checkUsernameExists(user.getUsername());
        if (user != null)
            return userRepository.save(user);
        return null; // exception handling обработка исключений
    }
    public User updateUser(Long userId, User user) {
        checkUsernameExists(user.getUsername());
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
    @SneakyThrows
    private void checkUsernameExists(String username) {
        if (userRepository.findByUsername(username) != null){
            throw new UserExistException("Username: " +  username + " already exists");
        }
    }
}
