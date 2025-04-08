package com.project.springboot.footballapp.entity;

import com.project.springboot.footballapp.repository.MemberRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="members")
public class Member {
    @Id
    @Column(name="user_id")
    private String username;

    @Column(name="active")
    private int active;

    public Member(){

    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Member(String username, int active, String password) {
        this.username = username;
        this.active = active;
        this.password = password;
    }

    @Column(name="pw")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
