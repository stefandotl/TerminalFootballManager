package game;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
public class TeamScore{

    @Id
    String name;
    int gamesPlayed;
    int goalsScored;
    int goalsConceded;
    int points;

    public TeamScore() {
    }

    public TeamScore(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void add3Points() {
        this.points += 3;
    }

    public void add1Point() {
        this.points += 1;
    }

    public void addGame() {
        this.gamesPlayed += 1;
    }

    public void addGoals(int goals) {
        this.goalsScored += goals;
    }

    public void addGoalsConceded(int goals) {
        this.goalsConceded += goals;
    }

    public List<Integer> getTeamScore() {
        return Arrays.asList(gamesPlayed, goalsScored, goalsConceded, points);
    }

    public String getName() {
        return name;
    }
}
