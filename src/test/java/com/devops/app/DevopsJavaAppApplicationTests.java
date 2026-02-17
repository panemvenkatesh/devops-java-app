package com.devops.app;

import com.devops.app.model.User;
import com.devops.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DevopsJavaAppApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    void testGetUserById() {
        User user = userService.getUserById(1L);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testCreateUser() {
        User newUser = new User(null, "Test User", "test@example.com", "Developer");
        User created = userService.createUser(newUser);
        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals("Test User", created.getName());
    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User(null, "Updated Name", "updated@example.com", "Admin");
        User result = userService.updateUser(1L, updatedUser);
        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
    }

    @Test
    void testDeleteUser() {
        boolean deleted = userService.deleteUser(2L);
        assertTrue(deleted);
    }

    @Test
    void testGetNonExistentUser() {
        User user = userService.getUserById(999L);
        assertNull(user);
    }
}
