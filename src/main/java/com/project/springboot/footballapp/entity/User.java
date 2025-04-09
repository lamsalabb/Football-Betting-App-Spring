package com.project.springboot.footballapp.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="username")
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    private String password;

    @Column(name="bet_coins")
    private int betCoins;

    @Column(name="active")
    private int active;

    @Column(name = "favorite_team")
    private String favoriteTeam;


    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Transient
    private String otp;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getBetCoins() {
        return betCoins;
    }

    public void setBetCoins(int betCoins) {
        this.betCoins = betCoins;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFavoriteTeam() {
        return favoriteTeam;
    }

    public void setFavoriteTeam(String favoriteTeam) {
        this.favoriteTeam = favoriteTeam;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", betCoins=" + betCoins +
                ", active=" + active +
                ", favoriteTeam='" + favoriteTeam + '\'' +
                '}';
    }
}
