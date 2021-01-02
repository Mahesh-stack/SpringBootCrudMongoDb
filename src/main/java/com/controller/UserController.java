package com.controller;

import com.entity.User;
import com.entity.UserStatus;
import com.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/addUserInfo")
    public User addUser(@RequestBody User user) {

        return userDao.addUser(user);
    }

    @PutMapping("/updateUserInfo")
    public User updateUser(@RequestBody User user) throws Exception {
        return userDao.updateUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/findUserById/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteUser(@PathVariable int id) {
        userDao.deleteById(id);
        return "BOOK DELETED WITH ID :" + getUser(id);
    }

    @GetMapping("/findByCreatedOn")
    public List<User> getUsersByCreatedDate(@RequestParam String createdOn) {
        return userDao.findAllByCreatedOn(createdOn);
    }

    @GetMapping("/findByUserStatus/{userStatus}")
    public List<User> getByUserStatus(@PathVariable UserStatus userStatus) {
        return userDao.findAllByUserStatus(userStatus);
    }

    // /Id/{Id}/Name/{Name}
    @GetMapping("/userStatus/{userStatus}/createdOn/{createdOn}")
    public List<User> findAllByUserStatusAndCreatedOn(@PathVariable("userStatus") UserStatus userStatus
            , @PathVariable("createdOn") String createdOn) {
        return userDao.findAllByCreatedOnAndUserStatus(userStatus, createdOn);
    }
}
