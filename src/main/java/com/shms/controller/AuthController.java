package com.shms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shms.model.User;
import com.shms.service.UserService;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Map<String,Object> login(
            @RequestBody User user){

        User validUser =
                service.login(
                        user.getUsername(),
                        user.getPassword());

        Map<String,Object> response =
                new HashMap<>();

        if(validUser != null){

            response.put("success", true);

            response.put("role",
                    validUser.getRole());

            response.put("message",
                    "Login Successful");

        }

        else{

            response.put("success", false);

            response.put("message",
                    "Invalid Credentials");
        }

        return response;
    }

}