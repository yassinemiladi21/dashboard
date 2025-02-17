package miladi.yassine.dashboard.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String season;
    private String date;
    private String time;
    private String homeTeam;
    private String awayTeam;
    private String homeGoals;
    private String awayGoals;
    private String result;
    private String winner;
    private String referee;
    private String homeShots;
    private String awayShots;
    private String homeShotsOnTarget;
    private String awayShotsOnTarget;
    private String homeCorners;
    private String awayCorners;
    private String homeFouls;
    private String awayFouls;
    private String homeYellowCards;
    private String awayYellowCards;
    private String homeRedCards;
    private String awayRedCards;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getHomeShots() {
        return homeShots;
    }

    public void setHomeShots(String homeShots) {
        this.homeShots = homeShots;
    }

    public String getAwayShots() {
        return awayShots;
    }

    public void setAwayShots(String awayShots) {
        this.awayShots = awayShots;
    }

    public String getHomeShotsOnTarget() {
        return homeShotsOnTarget;
    }

    public void setHomeShotsOnTarget(String homeShotsOnTarget) {
        this.homeShotsOnTarget = homeShotsOnTarget;
    }

    public String getAwayShotsOnTarget() {
        return awayShotsOnTarget;
    }

    public void setAwayShotsOnTarget(String awayShotsOnTarget) {
        this.awayShotsOnTarget = awayShotsOnTarget;
    }

    public String getHomeCorners() {
        return homeCorners;
    }

    public void setHomeCorners(String homeCorners) {
        this.homeCorners = homeCorners;
    }

    public String getAwayCorners() {
        return awayCorners;
    }

    public void setAwayCorners(String awayCorners) {
        this.awayCorners = awayCorners;
    }

    public String getHomeFouls() {
        return homeFouls;
    }

    public void setHomeFouls(String homeFouls) {
        this.homeFouls = homeFouls;
    }

    public String getAwayFouls() {
        return awayFouls;
    }

    public void setAwayFouls(String awayFouls) {
        this.awayFouls = awayFouls;
    }

    public String getHomeYellowCards() {
        return homeYellowCards;
    }

    public void setHomeYellowCards(String homeYellowCards) {
        this.homeYellowCards = homeYellowCards;
    }

    public String getAwayYellowCards() {
        return awayYellowCards;
    }

    public void setAwayYellowCards(String awayYellowCards) {
        this.awayYellowCards = awayYellowCards;
    }

    public String getHomeRedCards() {
        return homeRedCards;
    }

    public void setHomeRedCards(String homeRedCards) {
        this.homeRedCards = homeRedCards;
    }

    public String getAwayRedCards() {
        return awayRedCards;
    }

    public void setAwayRedCards(String awayRedCards) {
        this.awayRedCards = awayRedCards;
    }
}
