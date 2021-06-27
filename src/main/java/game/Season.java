package game;

import excpetions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Season {

    List<Team> teams = new ArrayList<>();
    LeagueTable leagueTable = new LeagueTable();
    private int numOfMatchDays = 2 * 17;
    private int gamesPerMatchDay = 9;
    public List<Game> gamesFirstLeg = new ArrayList<>();
    private List<MatchDay> listMatchDays = Arrays.asList(new MatchDay[numOfMatchDays]);
    private List<Integer> playedGamesTeamIndizes = new ArrayList<>();

    public static void log(Level level, String msg) {
        // Create a Logger
        Logger logger = Logger.getLogger(Season.class.getName());
    }

    public Season() {
        this.teams = generateTeams();
        generateMatchdays();
        this.leagueTable = generateLeagueTable();
    }

    public Season(boolean generate) {
        if (generate == true) {
            this.teams = generateTeams();
            generateMatchdays();
            this.leagueTable = generateLeagueTable();
        } else {
            Logger.getLogger(Season.class.getName()).info("No teams will be generated");
        }
    }

    private int teamStrength;

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }

    public List<MatchDay> getListMatchDays() {
        return listMatchDays;
    }

    public void setListMatchDays(List<MatchDay> listMatchDays) {
        this.listMatchDays = listMatchDays;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean hasEnoughTeams() {
        return teams.size() == 20 || teams.size() == 18 || teams.size() == 16;
    }

    public List<Team> generateTeams() {
        String fileName = "teams.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(teamName -> teams.add(new Team(teamName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    private LeagueTable generateLeagueTable() {
        for (Team team : teams) {
            leagueTable.addTeam(team);
        }
        return leagueTable;
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public void printTable() {
        leagueTable.printTable();
    }

    public void generateMatchdays() {
        try {
            int matches = numOfMatchDays;
            for (int i = 0; i < matches; i++) {
                MatchDay matchDay = generateEmptyMatches(gamesPerMatchDay);
                listMatchDays.set(i, matchDay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private MatchDay generateEmptyMatches(int gamesPerMatchDay) throws Exception {
        MatchDay matchDay = new MatchDay();
        for (int i = 0; i < gamesPerMatchDay; i++) {
            Game game = new Game();
            matchDay.addGame(game);
        }
        return matchDay;
    }

    public MatchDay getMatchday(int i) {
        var matchDay = this.listMatchDays.get(i);

        return matchDay;
    }

    public List<MatchDay> getAllMatchdays() {
        return listMatchDays;
    }

    public MatchDay generateMatchday(int matchDayNum) {
        int matchNum = teams.size() / 2;
        MatchDay matchDay = new MatchDay(matchNum);
        int indHome = matchDayNum;
        int indAway = indHome + 1;
        for (int i = 0; i < matchNum; i++) {
            var game = matchDay.getGame(i);
            boolean gameAdded = false;
            while (!gameAdded) {
                if (indHome == indAway){
                    indHome += 1;
                }
                Team homeTeam = teams.get(indHome % 18);
                Team awayTeam = teams.get(indAway % 18);
                Game testGame = new Game(homeTeam, awayTeam);
                try {
                    if (matchDay.teamIsPlaying(homeTeam)){
                        throw new HomeTeamAlreadyPlaysException("This Team is already Playing this Matchday");
                    } else if (matchDay.teamIsPlaying(awayTeam)){
                        throw new AwayTeamAlreadyPlaysException("This Team is already Playing this Matchday");
                    } else if (gameIsInFirstLeg(testGame)){
                        throw new GameIsAlreadyPlayedException("This Teams are already Playing");
                    } else {
                        game.addTeams(homeTeam, awayTeam);
                        indHome += 2;
                        indAway += 2;
                        gamesFirstLeg.add(game);
                        gameAdded = true;
                    }
                } catch (HomeTeamAlreadyPlaysException e){
                    indHome += 1;
                } catch (AwayTeamAlreadyPlaysException | GameIsAlreadyPlayedException e){
                    indAway += 1;
                }
            }
        }
        return matchDay;
    }

    public boolean gameIsInFirstLeg(Game testGame){
        var testHomeTeam = testGame.getHomeTeam();
        var testAwayTeam = testGame.getAwayTeam();
        for (Game game : gamesFirstLeg){
            var homeTeam = game.getHomeTeam();
            var awayTeam = game.getAwayTeam();
            if ((testHomeTeam == homeTeam) && (testAwayTeam == awayTeam)){
                return true;
            }
        }
        return false;
    }
}