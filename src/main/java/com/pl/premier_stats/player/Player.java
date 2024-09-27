package com.pl.premier_stats.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="player_stats")
public class Player {

    @Id
    @Column(name = "player_name", unique = true)
    private String playerName;
    private String nation;
    private String position;
    private String club;
    private String age;
    private Integer ageFiltered;
    private Integer matchesPlayed;
    private Integer starts;
    private Float minutesPlayed;
    private Float goals;
    private Float assists;
    private Float goalsAssists;
    private Float yellowCards;
    private Float redCards;
    private Float expectedGoals;
    private Float expectedAssists;

    public Player(Float expectedAssists, Float expectedGoals, Float redCards, Float yellowCards, Float goalsAssists, Float assists, Float goals, Float minutesPlayed, Integer starts, Integer matchesPlayed, Integer ageFiltered, String age, String club, String position, String nation, String playerName) {
        this.expectedAssists = expectedAssists;
        this.expectedGoals = expectedGoals;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
        this.goalsAssists = goalsAssists;
        this.assists = assists;
        this.goals = goals;
        this.minutesPlayed = minutesPlayed;
        this.starts = starts;
        this.matchesPlayed = matchesPlayed;
        this.ageFiltered = ageFiltered;
        this.age = age;
        this.club = club;
        this.position = position;
        this.nation = nation;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public String getNation() {
        return nation;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setClub(String club) {
        this.club = club;
    }


}
