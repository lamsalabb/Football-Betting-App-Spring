package com.project.springboot.footballapp.repository;

import com.project.springboot.footballapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
