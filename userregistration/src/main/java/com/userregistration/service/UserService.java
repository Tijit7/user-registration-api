package com.userregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   
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
        return null; 
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
}
