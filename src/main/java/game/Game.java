package game;

import excpetions.HomeTeamIsAwayTeamException;
import excpetions.NotEnoughTeamsException;
import excpetions.TeamIsAlreadyPlayingException;
import excpetions.ToManyTeamsException;

import java.util.*;

public class Game {

    private Team homeTeam;
    private Team awayTeam;
    public List<Team> teams;
    private int goalsHomeTeam;
    private int goalsAwayTeam;
    private boolean isRunning;
    private TeamScore homeTeamScore;
    private TeamScore awayTeamScore;

    public Game(Team homeTeam, Team awayTeam) {
        this.teams = new ArrayList<>();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
//        teams.set(0, homeTeam);
//        teams.set(1, awayTeam);
        teams.add(homeTeam);
        teams.add(awayTeam);
    }

    public Game() {
        this.teams = new ArrayList<>();
    }

    public boolean gameHasTwoTeams() {
        return homeTeam != null && awayTeam != null;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) throws ToManyTeamsException, HomeTeamIsAwayTeamException{
        switch (teams.size()) {
            case 0 -> {
                this.homeTeam = team;
                teams.add(team);
            }
            case 1 -> {
                if (homeTeam == team){
                    throw new HomeTeamIsAwayTeamException();
                }
                this.awayTeam = team;
                teams.add(team);
            }
            default -> throw new ToManyTeamsException();
        }
    }

    public void setTeam(Team team) throws ToManyTeamsException{
        if (teams.get(0) == null) {
            teams.set(0, team);
        } else if (teams.get(1) == null) {
            teams.set(1, team);
        } else {
            throw new ToManyTeamsException();
        }
    }

    public void addTeams(Team homeTeam, Team awayTeam){
        try {
            if (homeTeam == awayTeam){
                throw new HomeTeamIsAwayTeamException();
            } else {
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                teams.add(homeTeam);
                teams.add(awayTeam);
            }
        } catch ( HomeTeamIsAwayTeamException e){
            e.printStackTrace();
        }

    }

    public void setTeams(Team homeTeam, Team awayTeam) throws HomeTeamIsAwayTeamException{
        if (homeTeam == awayTeam){
            throw new HomeTeamIsAwayTeamException();
        } else {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            teams.set(0, homeTeam);
            teams.set(1, awayTeam);
        }
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

    public void start() throws NotEnoughTeamsException{
        if (gameHasTwoTeams()) {
            this.isRunning = true;
        } else {
            throw new NotEnoughTeamsException();
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
        try {
            start();
        } catch (NotEnoughTeamsException e) {
            e.printStackTrace();
        }
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
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
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

    public void addHomeTeam(Team team){
        this.homeTeam = team;
        teams.add(team);
    }
}
