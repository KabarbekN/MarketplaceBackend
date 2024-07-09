package kz.itstep.rest2.controller;

import kz.itstep.rest2.model.User;
import kz.itstep.rest2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    // localhost:8080

    @GetMapping("/") // localhost:8080/ GET
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}") // localhost:8080/856
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/") // localhost:8080/ POST
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/create")
    public User addUser(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password
                        ){
        return userService.createUser(new User(username, password));
    }

//    @PatchMapping

//    @DeleteMapping

}
