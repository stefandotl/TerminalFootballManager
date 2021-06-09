package game;

import excpetions.TeamNumberNotEqualTwoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<Team> teams = new ArrayList<>();
    private int goalsHomeTeam;
    private int goalsAwayTeam;
    private boolean isRunning;
    private TeamScore homeTeamScore;
    private TeamScore awayTeamScore;
    private Team homeTeam;
    private Team awayTeam;

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
        this.goalsHomeTeam += 1;
    }

    public int getGoalsHomeTeam() {
        return this.goalsHomeTeam;
    }

    public void awayTeamScored() {
        this.goalsAwayTeam += 1;
    }

    public int getGoalsAwayTeam() {
        return this.goalsAwayTeam;
    }

    public boolean homeTeamWins() {
        return goalsHomeTeam > goalsAwayTeam;
    }

    public boolean awayTeamWins() {
        return goalsHomeTeam < goalsAwayTeam;
    }

    public boolean gameEndsDraw() {
        return goalsHomeTeam == goalsAwayTeam;
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
        System.out.printf("%s  %s : %s  %s", teams.get(0).getName(), this.goalsHomeTeam, this.goalsAwayTeam, teams.get(1).getName());
    }

    public void printScoreWithoutTeams() {
        System.out.printf("%s : %s", this.goalsHomeTeam, this.goalsAwayTeam);
    }

    public void simulateRandomScore() {
//        fixme: make normaldistributions Score
        homeTeam = teams.get(0);
        awayTeam = teams.get(1);
        start();
        Random rand = new Random();
        this.goalsHomeTeam = rand.nextInt(5);
        this.goalsAwayTeam = rand.nextInt(5);
        end();
        givePointsToTeam(homeTeam, awayTeam);
        giveGoalsAndGames(homeTeam, awayTeam);
    }

    private void giveGoalsAndGames(Team homeTeam, Team awayTeam) {
        this.homeTeamScore = homeTeam.getTeamScore();
        this.awayTeamScore = awayTeam.getTeamScore();
        homeTeamScore.addGame();
        awayTeamScore.addGame();
        homeTeamScore.addGoals(goalsHomeTeam);
        homeTeamScore.addGoalsConceded(goalsAwayTeam);
        awayTeamScore.addGoals(goalsAwayTeam);
        awayTeamScore.addGoalsConceded(goalsHomeTeam);
    }

    public Team getHomeTeam() {
        return teams.get(0);
    }

    public Team getAwayTeam() {
        return teams.get(1);
    }

    public void givePointsToTeam(Team homeTeam, Team awayTeam) {
        this.homeTeamScore = homeTeam.getTeamScore();
        this.awayTeamScore = awayTeam.getTeamScore();

        if (homeTeamWins()) {
            homeTeamScore.add3Points();
        } else if (awayTeamWins()) {
            awayTeamScore.add3Points();
        } else {
            homeTeamScore.add1Point();
            awayTeamScore.add1Point();
        }
    }
}
