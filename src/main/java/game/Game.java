package game;

import excpetions.TeamNumberNotEqualTwoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<Team> teams = new ArrayList<>();
    private int scoreHomeTeam;
    private int scoreAwayTeam;
    private boolean isRunning;

    public boolean gameHasTwoTeams() {
        return this.teams.size() == 2;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void addTeams(Team homeTeam, Team awayTeam) {
        teams.add(homeTeam);
        teams.add(awayTeam);
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

    public void start() {
        try {
            if (gameHasTwoTeams()) {
                this.isRunning = true;
            } else{
                throw new TeamNumberNotEqualTwoException();
            }
        } catch (TeamNumberNotEqualTwoException e) {
            e.printStackTrace();
        }
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
//        fixme: make normaldistributions Score
        start();
        Random rand = new Random();
        this.scoreHomeTeam = rand.nextInt(5);
        this.scoreAwayTeam = rand.nextInt(5);
        end();
    }

    public Team getHomeTeam() {
        return teams.get(0);
    }

    public Team getAwayTeam() {
        return teams.get(1);
    }

    public void givePointsToTeam() {
        TeamScore homeTeam = (TeamScore) getHomeTeam();
        TeamScore awayTeam = (TeamScore) getAwayTeam();

        if (homeTeamWins()) {
            homeTeam.add3Points();
        } else if (awayTeamWins()) {
            awayTeam.add3Points();
        } else {
            homeTeam.add1Point();
            awayTeam.add1Point();
        }
    }
}
