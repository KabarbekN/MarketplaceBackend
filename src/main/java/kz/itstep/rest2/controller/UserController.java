package kz.itstep.rest2.controller;

import jakarta.validation.Valid;
import kz.itstep.rest2.model.User;
import kz.itstep.rest2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") //localhost:8080/user
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    // localhost:8080

//    @GetMapping("/") // localhost:8080/user/ GET
//    public ResponseEntity<List<User>> getAllUsers(){
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatusCode.valueOf(202));
//    }

    @GetMapping("/") // localhost:8080/user/ GET
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.accepted().body(userService.getAllUsers());
    }

    @GetMapping("/{id}") // localhost:8080/user/856
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/username/{username}") //localhost:8080/user/username/dynamicValue
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping("/") // localhost:8080/user/ POST
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/create") //localhost:8080/user/create POST
    public ResponseEntity<?> addUser(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password
                        ){
        return ResponseEntity.ok(userService.createUser(new User(username, password)));
    }

    @PatchMapping("/{id}") // localhost:8080/user/ METHOD=PATCH
    public ResponseEntity<?> updateUser(@PathVariable Long id ,@RequestBody User user){
        return ResponseEntity.accepted().body(userService.updateUser(id, user));
    }

//    @DeleteMapping("/user/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.accepted().body("User with id: " + id + " was deleted.");
    }
}
