package com.visualflow.webapp.service;

import com.visualflow.webapp.model.User;
import com.visualflow.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allList(){
        return (List<User>) userRepository.findAll();
    }

}
