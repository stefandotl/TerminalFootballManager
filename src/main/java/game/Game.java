package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<String> teams = new ArrayList<>();
    private int scoreHomeTeam;
    private int scoreAwayTeam;
    private boolean isRunning;

    public boolean gameHasTwoTeams() {
        return this.teams.size() == 2;
    }

    public void addTeams(Team homeTeam, Team awayTeam) {
        teams.add(homeTeam.getName());
        teams.add(awayTeam.getName());
    }

    public void homeTeamScored() {
        this.scoreHomeTeam += 1;
    }

    public int getScoreHomeTeam() {
        return this.scoreHomeTeam;
    }

    public void awayTeamScored() {
        this.scoreAwayTeam += 1;
    }

    public int getScoreAwayTeam() {
        return this.scoreAwayTeam;
    }

    public boolean homeTeamWins() {
        return scoreHomeTeam > scoreAwayTeam;
    }

    public boolean awayTeamWins() {
        return scoreHomeTeam < scoreAwayTeam;
    }

    public boolean gameEndsDraw() {
        return scoreHomeTeam == scoreAwayTeam;
    }

    public void start(){
//        TODO: If game has not two teams, throw exception
//        gameHasTwoTeams()
        this.isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void end() {
        this.isRunning = false;
    }

    public void printScore() {
        System.out.printf("%s  %s : %s  %s", teams.get(0), this.scoreHomeTeam, this.scoreAwayTeam, teams.get(1));
    }

    public void printScoreWithoutTeams() {
        System.out.printf("%s : %s", this.scoreHomeTeam, this.scoreAwayTeam);
    }

    public void simulateRandomScore() {
        Random rand = new Random();
        this.scoreHomeTeam = rand.nextInt(5);
        this.scoreAwayTeam = rand.nextInt(5);
    }

    public Team getHomeTeam(int index) {
        return this.teams.get(index);
    }
}
