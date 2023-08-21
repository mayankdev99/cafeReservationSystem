package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cafe.entity.Admin;
import cafe.entity.User;
import cafe.service.UserService;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin")
    public Iterable<Admin> getAdmin() {
        return userService.getAllAdmins();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/{id}")
    public Admin getAdmin(@PathVariable("id") Integer id) {
        return userService.getAdminById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/admin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return userService.createAdmin(admin);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/admin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return userService.updateAdmin(admin);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    public Iterable<User> getUser() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/login")
    public User loginUser(@RequestParam("email") String email, @RequestParam("mobileno") String mobileno) {
        return userService.loginUser(email, mobileno);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/{userId}")  // Specify the userId path variable
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser); // Call the updatedUser method with userId and updatedUser
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/user/changepassword")
    public ResponseEntity<Map<String, String>> changePassword(@RequestBody Map<String, String> request) {
        return userService.changeUserPassword(request);
    }
}

