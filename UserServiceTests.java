package cafe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import cafe.entity.Admin;
import cafe.entity.User;
import cafe.repository.AdminRepo;
import cafe.repository.UserRepo;
import cafe.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        // You can perform setup tasks here if needed
    }

    @Test
    public void testCreateAdmin() {
        Admin admin = new Admin();
        admin.setAdmin("admin");
        admin.setPassword("password");

        Admin createdAdmin = userService.createAdmin(admin);

        assertNotNull(createdAdmin);
        assertNotNull(createdAdmin.getId());
        assertEquals("admin", createdAdmin.getAdmin());
        assertEquals("password", createdAdmin.getPassword());

        // Perform more assertions if needed
    }

    @Test
    public void testGetAdminById() {
        // Create a sample admin in the repository
        Admin admin = new Admin();
        admin.setAdmin("admin");
        admin.setPassword("password");
        adminRepo.save(admin);

        Admin retrievedAdmin = userService.getAdminById(admin.getId());

        assertNotNull(retrievedAdmin);
        assertEquals("admin", retrievedAdmin.getAdmin());
        assertEquals("password", retrievedAdmin.getPassword());

        // Perform more assertions if needed
    }

    @Test
    public void testGetAllAdmins() {
        // Create some sample admins in the repository
        // (You can add more admin entries as needed)
        Admin admin1 = new Admin();
        admin1.setAdmin("admin1");
        admin1.setPassword("password1");
        adminRepo.save(admin1);

        Admin admin2 = new Admin();
        admin2.setAdmin("admin2");
        admin2.setPassword("password2");
        adminRepo.save(admin2);

        Iterable<Admin> admins = userService.getAllAdmins();

        assertNotNull(admins);
        // Check the size or specific properties of the retrieved admins
    }

    @Test
    public void testUpdateAdmin() {
        // Create a sample admin in the repository
        Admin admin = new Admin();
        admin.setAdmin("admin");
        admin.setPassword("password");
        adminRepo.save(admin);

        admin.setPassword("newpassword");
        Admin updatedAdmin = userService.updateAdmin(admin);

        assertNotNull(updatedAdmin);
        assertEquals("admin", updatedAdmin.getAdmin());
        assertEquals("newpassword", updatedAdmin.getPassword());

        // Perform more assertions if needed
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        // Set properties of the user object
        // ...

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getUserId());
        // Perform more assertions based on the properties you've set
    }

    @Test
    public void testGetUserById() {
        // Create a sample user in the repository
        User user = new User();
        // Set properties of the user object
        // ...
        userRepo.save(user);

        User retrievedUser = userService.getUserById(user.getUserId());

        assertNotNull(retrievedUser);
        // Perform more assertions based on the properties you've set
    }

    @Test
    public void testLoginUser() {
        // Create a sample user in the repository
        User user = new User();
        userRepo.save(user);

        User loggedInUser = userService.loginUser("swetha@mail.com","2345678901");

        assertNotNull(loggedInUser);
    
    }

    @Test
    public void testChangeUserPassword() {
    	 int userId = 1;

    	    // Create a sample user in the repository
    	    User user = new User();
        userRepo.save(user);

        Map<String, String> request = new HashMap<>();
        request.put("userId", String.valueOf(userId));  // Use "userId" instead of "Id"
        request.put("oldPassword", "new456");
        request.put("newPassword", "old456");

        ResponseEntity<Map<String, String>> responseEntity = userService.changeUserPassword(request);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Password changed successfully", responseEntity.getBody().get("message"));
    }
}

