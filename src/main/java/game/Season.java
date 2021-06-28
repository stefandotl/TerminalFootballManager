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
    private final int numOfMatchDaysFirstLeg = 17;
    private final int numOfMatchDays = 2 * numOfMatchDaysFirstLeg;
    private final int gamesPerMatchDay = 9;
    public List<Game> allGamesCombinations = new ArrayList<>();
    public List<Game> gamesFirstLeg = new ArrayList<>();
    public List<MatchDay> matchDaysFirstLeg = new ArrayList<>();
    private List<MatchDay> listMatchDays = new ArrayList<>();
    private final List<Integer> playedGamesTeamIndizes = new ArrayList<>();

    public static void log(Level level, String msg) {
        // Create a Logger
        Logger logger = Logger.getLogger(Season.class.getName());
    }

    public Season() {
        try {
            this.teams = generateTeams();
            generateMatchdaysSeason();
            this.leagueTable = generateLeagueTable();
        } catch (TeamIsAlreadyPlayingException e) {
            e.printStackTrace();
        }
    }

    public void generateMatchdaysSeason() throws TeamIsAlreadyPlayingException {
        int matches = numOfMatchDaysFirstLeg;
        for (int i = 0; i < matches; i++) {
//            todo: add second leg (you need second list = reverse teams list)
            MatchDay matchDay = generateMatchdayV3(teams);
            teams.add(0, teams.get(teams.size() - 1));
            teams.remove(teams.size() - 1);
            listMatchDays.add(matchDay);
        }
    }

    public MatchDay generateMatchdayV3(List<Team> teams) throws TeamIsAlreadyPlayingException {
        int matchNum = teams.size() / 2;
        MatchDay matchDay = new MatchDay();
        int index = 0;
        for (int i = 0; i < matchNum; i++) {
            Game game = new Game(teams.get(index % 18), teams.get((index + 1) % 18));
            matchDay.addGame(game);
            gamesFirstLeg.add(game);
            index += 2;
        }
        listMatchDays.add(matchDay);
        matchDaysFirstLeg.add(matchDay);
        return matchDay;
    }


    public Season(boolean generate) {
        try {
            if (generate == true) {
                this.teams = generateTeams();
                generateMatchdaysSeason();
                this.leagueTable = generateLeagueTable();
            } else {
                Logger.getLogger(Season.class.getName()).info("No teams will be generated");
            }
        } catch (TeamIsAlreadyPlayingException e) {
            e.printStackTrace();
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
//        todo: shuffle teams;
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

    public MatchDay getMatchday(int i) {
        var matchDay = this.listMatchDays.get(i);
        return matchDay;
    }

    public List<MatchDay> getAllMatchdays() {
        return listMatchDays;
    }

}