package kz.itstep.rest2.service;

import kz.itstep.rest2.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);

    User getUserByUsername(String username);

    User createUser(User user);

    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    List<User> getAllUsers();




}
