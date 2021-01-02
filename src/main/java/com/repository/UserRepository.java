package com.repository;

import com.entity.User;
import com.entity.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    List<User> findAllByCreatedOn(String createdOn);

    List<User> findAllByUserStatus(UserStatus userStatus);

    List<User> findAllByCreatedOnAndUserStatus(String createdOn, UserStatus userStatus);
}
