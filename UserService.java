package cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cafe.entity.Admin;
import cafe.entity.User;
import cafe.exception.ResourceNotFoundException;
import cafe.repository.AdminRepo;
import cafe.repository.UserRepo;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private UserRepo userRepo;

    public Iterable<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Admin getAdminById(Integer id) {
        return adminRepo.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public User loginUser(String email, String mobileno) {
        return userRepo.findByEmailidAndMobileno(email, mobileno).orElse(null);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(int userId, User updatedUser) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        existingUser.setName(updatedUser.getName());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setDob(updatedUser.getDob());
        existingUser.setEmailid(updatedUser.getEmailid());
        existingUser.setGender(updatedUser.getGender());
        existingUser.setMobileno(updatedUser.getMobileno());

        return userRepo.save(existingUser);
    }

    public ResponseEntity<Map<String, String>> changeUserPassword(Map<String, String> request) {
        String userIdStr = request.get("userId");
        int userId = userIdStr != null ? Integer.parseInt(userIdStr) : -1; // Default to -1 if userIdStr is null
        String oldPassword = request.get("oldPassword");
        String newPassword = request.get("newPassword");

        if (userId == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid user ID"));
        }

        User user = userRepo.findById(userId).orElse(null);

        if (user == null || !user.getMobileno().equals(oldPassword)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Invalid credentials"));
        }

        user.setMobileno(newPassword); // Update the password ( mobile number is the password)
        userRepo.save(user);

        return ResponseEntity.ok(Map.of("message", "Password changed successfully"));
    }
}


