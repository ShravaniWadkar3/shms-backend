package com.shms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shms.model.User;
import com.shms.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String username,
                      String password) {

        return repo.findByUsernameAndPassword(
                username,
                password);
    }

}