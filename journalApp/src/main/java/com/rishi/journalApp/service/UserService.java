package com.rishi.journalApp.service;

import com.rishi.journalApp.entity.User;
import com.rishi.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId myId) {
        return userRepository.findById(myId);
    }

    public void deleteUser(ObjectId myId) {
        userRepository.deleteById(myId);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}

// controller --> service --> repository