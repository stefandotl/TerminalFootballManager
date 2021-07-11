package game;

import excpetions.TeamIsAlreadyPlayingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Season {

    List<Team> teams = new ArrayList<>();
    LeagueTable leagueTable = new LeagueTable();
    private final int numOfMatchDaysFirstLeg = 17;
    public List<Game> gamesFirstLeg = new ArrayList<>();
    public List<MatchDay> matchDaysFirstLeg = new ArrayList<>();
    public List<MatchDay> matchDaysSecondLeg = new ArrayList<MatchDay>();
    private List<MatchDay> listMatchDays = new ArrayList<>();

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
        int matchesFirstLeg = numOfMatchDaysFirstLeg;
        for (int i = 0; i < matchesFirstLeg; i++) {
            MatchDay matchDay = generateMatchday(i, teams);
            teams.add(1, teams.get(teams.size() - 1));
            teams.remove(teams.size() - 1);
            listMatchDays.add(matchDay);
            if(matchDaysFirstLeg.size()==teams.size()-1){
                matchDaysSecondLeg = reverse(matchDaysFirstLeg);
            }
        }
    }

    private List<MatchDay> reverse(List<MatchDay> matchDaysFirstLeg) throws TeamIsAlreadyPlayingException {
        for(MatchDay matchDay : matchDaysFirstLeg){
            MatchDay matchDay2 = new MatchDay();
            for (Game game : matchDay.getGames()){
                var teams = game.getTeams();
                Team homeTeam = teams.get(1);
                Team awayTeam = teams.get(0);
                Game game2 = new Game(homeTeam, awayTeam);
                matchDay2.addGame(game2);
            }
            matchDaysSecondLeg.add(matchDay2);
            listMatchDays.add(matchDay2);
        }
        return matchDaysSecondLeg;
    }

    public MatchDay generateMatchday(int matchDayNum, List<Team> teams) throws TeamIsAlreadyPlayingException {
//        todo: No it's still not working! Round Robin!
        int matchNum = teams.size() / 2;

        List<Team> l1 = new ArrayList<>();
        for(int j=0; j<matchNum; j++){
            l1.add(teams.get(j));
        }

        List<Team> l2 = new ArrayList<>();
        for (int i=(teams.size()-1); i>=matchNum; i--){
            l2.add(teams.get(i));
        }

        MatchDay matchDay = new MatchDay();
        for (int i = 0; i < matchNum; i++) {

            if(matchDayNum %2 == 1){
                Game game1 = new Game(l1.get(i), l2.get(i));
                matchDay.addGame(game1);
                gamesFirstLeg.add(game1);
            } else {
                Game game = new Game(l2.get(i), l1.get(i));
                matchDay.addGame(game);
                gamesFirstLeg.add(game);
            }

        }
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

    public List<MatchDay> getMatchDaysFirstLeg() {
        return matchDaysFirstLeg;
    }

}