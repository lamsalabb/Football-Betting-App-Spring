package com.project.springboot.footballapp.repository;

import com.project.springboot.footballapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
