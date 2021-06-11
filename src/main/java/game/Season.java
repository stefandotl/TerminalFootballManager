package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Season {

    List<Team> teams = new ArrayList<>();
    MatchDay matchDay = new MatchDay();
    LeagueTable leagueTable = new LeagueTable();
    List<MatchDay> ListMatchDays = new ArrayList<>();

    public Season() {
        this.teams = generateTeams();
        this.leagueTable = generateLeagueTable();
    }

    public Season(boolean generate) {
        if (generate) {
            this.teams = generateTeams();
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
        return ListMatchDays;
    }

    public void setListMatchDays(List<MatchDay> listMatchDays) {
        ListMatchDays = listMatchDays;
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

    public void generateMatchdays() {
        int matches = (teams.size() - 1)*2;

        for (int i=0; i<matches; i++){
            MatchDay matchDay = generateMatches(i);
            this.ListMatchDays.add(matchDay);
        }
    }

    private MatchDay generateMatches(int matchDayNumber) {
        MatchDay matchDay = new MatchDay();
        int matches = teams.size() / 2;
        int indexHome = matchDayNumber;
        int indexAway = matchDayNumber+1;
        for (int i = 0; i < matches; i++) {
            Game game = new Game();
            game.addTeams(teams.get(indexHome % 17), teams.get(indexAway % 17));
            matchDay.addGame(game);
            indexHome += 2;
            indexAway += 2;
        }
        return matchDay;
    }

    public MatchDay getMatchday() {
        /*todo: add game to season and check if game and if its the same when host and guest swaps, first leg/second leg,
         *  if if team has played against an oppponent ones -> after that => second leg! */
        int matches = teams.size() / 2;
        MatchDay matchDay = new MatchDay();
        int index = 0;

        for (int i = 0; i < matches; i++) {
            Game game = new Game();
            game.addTeams(teams.get(index), teams.get(index + 1));
            matchDay.addGame(game);
            index += 2;
        }

        return matchDay;
    }

}