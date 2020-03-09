package com.example.demo5.service;

import com.example.demo5.persistance.repository.UserRepository;
import com.example.demo5.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean createUser(User user){
        userRepository.save(user);
        return true;
    }
    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public boolean updateUserById(Long id, User user){
        User toUpdate = userRepository.findById(id).get();
        toUpdate.setName(user.getName());
        toUpdate.setPass(user.getPass());
        userRepository.save(toUpdate);
        deleteUserById(id);
        return true;
    }

    public boolean deleteUserById(Long id){
         userRepository.deleteById(id);
         return true;
    }
}
