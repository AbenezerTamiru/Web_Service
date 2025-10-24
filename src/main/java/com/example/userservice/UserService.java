package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private long nextId = 1; 

    public List<User> getAllUsers() {
        return new ArrayList<>(users); 
    }

    public User addUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User existingUser = users.get(i);
            if (existingUser.getId().equals(id)) {
                
                updatedUser.setId(id);
                users.set(i, updatedUser);
                return Optional.of(updatedUser);
            }
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }

  
    public boolean userExists(Long id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }

 
    public int getUserCount() {
        return users.size();
    }
}