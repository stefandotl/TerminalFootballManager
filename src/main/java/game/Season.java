package game;

import excpetions.ToManyTeamsException;
import org.apache.logging.slf4j.Log4jLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Season {

    List<Team> teams = new ArrayList<>();
    MatchDay matchDay = new MatchDay();
    LeagueTable leagueTable = new LeagueTable();
    List<MatchDay> listMatchDays = new ArrayList<>();
    List<Integer> playedGamesTeamIndizes = new ArrayList<>();

    public static void log(Level level, String msg){
        // Create a Logger
        Logger logger = Logger.getLogger(Season.class.getName());
    }

    public Season() {
        this.teams = generateTeams();
        generateMatchdays();
        this.leagueTable = generateLeagueTable();
    }

    public Season(boolean generate) {
        if(generate == true){
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
//        todo: check which country you have and adjust league size
        return teams.size() == 20 || teams.size() == 18 || teams.size() == 16 ;
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

    public void generateMatchdays(){
        int matches = (teams.size() - 1)*2;

        for (int i=0; i<matches; i++){
            MatchDay matchDay = generateMatches(i);
            this.listMatchDays.add(matchDay);
        }
    }

    private MatchDay generateMatches(int matchDayNumber){
//        fixme: games are not randomly
        MatchDay matchDay = new MatchDay();
        int matches = teams.size() / 2;
        int index = matchDayNumber;
        for (int i = 0; i < matches; i++) {
            Game game = new Game();
            game.addTeams(teams.get(index % 17), teams.get((index + 1) % 17));
            matchDay.addGame(game);
            index += 2;
        }
        return matchDay;
    }

    private void generateMatchesForTeams() {
        for (Team team: teams){
            for (int i=0; i<17; i++){
//            fixme: define array size
            }
        }
    }

    public MatchDay getMatchday(int i) {
        var matchDay = this.listMatchDays.get(i);

        return matchDay;
    }

    public List<MatchDay> getAllMatchdays() {
        return listMatchDays;
    }

}