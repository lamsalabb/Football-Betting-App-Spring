package com.project.springboot.footballapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name="role")
    private String role;

    public Role() {}

    @Override
    public String toString() {
        return "Role{" +
                "user_id='" + user_id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Role(String user_id, String role) {
        this.user_id = user_id;
        this.role=role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
