package com.project.springboot.footballapp.service;

import com.project.springboot.footballapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);

    void delete(User user);

    User findByUsername(String username);


}
