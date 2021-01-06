package com.benchprojecttaskboard.benchprojecttaskboard.services;

import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import com.benchprojecttaskboard.benchprojecttaskboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
}
