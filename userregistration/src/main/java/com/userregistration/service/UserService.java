package com.userregistration.service;

import com.userregistration.model.User;
import com.userregistration.model.MongoUser;
import com.userregistration.repository.UserRepository;
import com.userregistration.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoUserRepository mongoUserRepository;

   
    public User registerUser(User user) {
        return userRepository.save(user);
    }

   
    public User updateUser(Long id, User userDetails) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(userDetails.getName());
            user.setGender(userDetails.getGender());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null; // or throw an exception
    }

  
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

  
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

  
    public MongoUser registerMongoUser(MongoUser mongoUser) {
        return mongoUserRepository.save(mongoUser);
    }

   
    public MongoUser updateMongoUser(String id, MongoUser userDetails) {
        Optional<MongoUser> userOpt = mongoUserRepository.findById(id);
        if (userOpt.isPresent()) {
            MongoUser user = userOpt.get();
            user.setName(userDetails.getName());
            user.setGender(userDetails.getGender());
            user.setPassword(userDetails.getPassword());
            return mongoUserRepository.save(user);
        }
        return null;
    }

   
    public void deleteMongoUser(String id) {
        mongoUserRepository.deleteById(id);
    }

   
    public List<MongoUser> getAllMongoUsers() {
        return mongoUserRepository.findAll();
    }

    
    public MongoUser getMongoUserByEmail(String email) {
        return mongoUserRepository.findByEmail(email);
    }
}
