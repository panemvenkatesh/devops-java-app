package com.devops.app.service;

import com.devops.app.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(List.of(
        new User(1L, "John Doe", "john@example.com", "Admin"),
        new User(2L, "Jane Smith", "jane@example.com", "Developer"),
        new User(3L, "Bob Wilson", "bob@example.com", "Tester")
    ));

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User createUser(User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                updatedUser.setId(id);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(u -> u.getId().equals(id));
    }
}
