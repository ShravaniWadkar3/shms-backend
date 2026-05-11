package com.shms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.model.User;

public interface UserRepository
extends JpaRepository<User, Integer>{

    User findByUsernameAndPassword(
            String username,
            String password);

}