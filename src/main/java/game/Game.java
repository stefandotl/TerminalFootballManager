package game;

import excpetions.NotEnoughTeamsException;
import excpetions.TeamAlreadyExistsException;
import excpetions.ToManyTeamsException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    private Team homeTeam;
    private Team awayTeam;
    List<Team> teams = Arrays.asList(null, null);
    private int goalsHomeTeam;
    private int goalsAwayTeam;
    private boolean isRunning;
    private TeamScore homeTeamScore;
    private TeamScore awayTeamScore;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        teams.set(0, homeTeam);
        teams.set(1, awayTeam);
    }

    public Game() {
    }

    public boolean gameHasTwoTeams() {
        try {
            if (homeTeam == awayTeam){
                throw new TeamAlreadyExistsException();
            }
        } catch (TeamAlreadyExistsException e) {
            e.printStackTrace();
        }
        return teams.get(0) != null && teams.get(1) != null;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) throws ToManyTeamsException{
        if (teams.get(0) == null) {
            teams.add(team);
        } else if (teams.get(1) == null) {
            teams.add(team);
        } else {
            throw new ToManyTeamsException();
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
            if (teams.get(0) != null || teams.get(1) != null) {
                throw new ToManyTeamsException();
            } else if (homeTeam == awayTeam){
                throw new TeamAlreadyExistsException();
            } else {
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                teams.add(homeTeam);
                teams.add(awayTeam);
            }
        } catch (ToManyTeamsException | TeamAlreadyExistsException e){
            e.printStackTrace();
        }

    }

    public void setTeams(Team homeTeam, Team awayTeam) throws ToManyTeamsException, TeamAlreadyExistsException {
        if (teams.get(0) != null || teams.get(1) != null) {
            throw new ToManyTeamsException();
        } else if (homeTeam == awayTeam){
            throw new TeamAlreadyExistsException();
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

    public void start() {
        try {
            if (gameHasTwoTeams()) {
                this.isRunning = true;
            } else {
                throw new NotEnoughTeamsException();
            }
        } catch (NotEnoughTeamsException e) {
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
        try {
            if (homeTeam == null) {
                this.homeTeam = team;
                teams.set(0, team);
            } else {
                throw new TeamAlreadyExistsException();
            }
        } catch (TeamAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void setHomeTeam(Team team) {
        this.homeTeam = team;
        teams.set(0, team);
    }

    public void addAwayTeam(Team team){
        try {
            if (awayTeam == null) {
                this.awayTeam = team;
                teams.set(1, team);
            } else {
                throw new TeamAlreadyExistsException();
            }
        } catch (TeamAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void setAwayTeam(Team team) {
        this.awayTeam = team;
        teams.set(1, team);
    }
}
