package com.project.springboot.footballapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long matchId;

    private String homeTeam;
    private String awayTeam;

    private int predictedHomeScore;
    private int predictedAwayScore;

    private int betAmount;

    private Boolean resultChecked = false;
    private Boolean isWin;

    private Integer actualHomeScore;
    private Integer actualAwayScore;

    private Integer payout;

    private LocalDateTime matchTime;

    private LocalDateTime placedAt = LocalDateTime.now();

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getPredictedHomeScore() {
        return predictedHomeScore;
    }

    public void setPredictedHomeScore(int predictedHomeScore) {
        this.predictedHomeScore = predictedHomeScore;
    }

    public int getPredictedAwayScore() {
        return predictedAwayScore;
    }

    public void setPredictedAwayScore(int predictedAwayScore) {
        this.predictedAwayScore = predictedAwayScore;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public Boolean getResultChecked() {
        return resultChecked;
    }

    public void setResultChecked(Boolean resultChecked) {
        this.resultChecked = resultChecked;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }

    public Integer getActualHomeScore() {
        return actualHomeScore;
    }

    public void setActualHomeScore(Integer actualHomeScore) {
        this.actualHomeScore = actualHomeScore;
    }

    public Integer getActualAwayScore() {
        return actualAwayScore;
    }

    public void setActualAwayScore(Integer actualAwayScore) {
        this.actualAwayScore = actualAwayScore;
    }

    public Integer getPayout() {
        return payout;
    }

    public void setPayout(Integer payout) {
        this.payout = payout;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }
}

