package com.impl;

import com.entity.User;
import com.entity.UserStatus;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedOn(date.toString());
        return userRepository.save(user);
    }

    public User updateUser(User user) throws Exception {
        Optional<User> existing = userRepository.findById(user.getUserId());
        if (!existing.isPresent()) {
            throw new Exception("User Id does not exist");
        }
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllByCreatedOn(String createdOn) {
        return userRepository.findAllByCreatedOn(createdOn);
    }

    public List<User> findAllByUserStatus(UserStatus userStatus) {
        return userRepository.findAllByUserStatus(userStatus);
    }

    public List<User> findAllByCreatedOnAndUserStatus(UserStatus userStatus, String createdOn) {
        return userRepository.findAllByCreatedOnAndUserStatus(createdOn,userStatus);
    }
}
