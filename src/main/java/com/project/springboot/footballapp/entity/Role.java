package com.project.springboot.footballapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }
    public Role(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Id
    @Column(name="user_id")
    private String username;

    @Column(name="role")
    private String role;
}
