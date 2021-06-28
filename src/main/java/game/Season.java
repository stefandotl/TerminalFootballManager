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
//                MatchDay matchDay = generateMatchday(i);
//            MatchDay matchDay = generateMatchdayV2();
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

    public MatchDay generateMatchdayV2() throws TeamIsAlreadyPlayingException {
        MatchDay matchDay = new MatchDay();
        for (int i = 0; i < gamesPerMatchDay; i++) {
            for (int j = 0; j < allGamesCombinations.size(); j++) {
                if (teamsAreNotPlayingThisMatchDay(matchDay, allGamesCombinations.get(j)) && teamsHaventPlayedThisLeg(allGamesCombinations.get(j))) {
                    matchDay.addGame(allGamesCombinations.get(j));
                    gamesFirstLeg.add(allGamesCombinations.get(j));
                    allGamesCombinations.remove(j);
                }
            }
        }
        return matchDay;
    }

    private boolean teamsHaventPlayedThisLeg(Game game) {
        var homeTeam = game.getHomeTeam();
        var awayTeam = game.getAwayTeam();
        for (Game gamePlayed : gamesFirstLeg) {
            var playedHomeTeam = gamePlayed.getHomeTeam();
            var playedAwayTeam = gamePlayed.getAwayTeam();
            if ((playedHomeTeam == homeTeam && playedAwayTeam == awayTeam) || (playedAwayTeam == homeTeam && playedHomeTeam == awayTeam)) {
                return false;
            }
        }
        return true;
    }

    private boolean teamsAreNotPlayingThisMatchDay(MatchDay matchDay, Game game) {
        for (Team team : game.getTeams()) {
            if (team != null) {
                for (Game gameInMatchDay : matchDay.getGames()) {
                    if (gameInMatchDay.getHomeTeam() == team || gameInMatchDay.getAwayTeam() == team) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void generateAllGamesCombinations() {
        for (Team team : teams) {
            for (int i = 0; i < teams.size(); i++) {
                if (team != teams.get(i)) {
                    Game game = new Game(team, teams.get(i));
                    allGamesCombinations.add(game);
                }
            }
        }
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

    public MatchDay generateMatchday(int matchDayNum) {
//        fixme: es kommen am Ende endlose exceptions! Mit rekursivem Ansatz loesen!
        int matchNum = teams.size() / 2;
        MatchDay matchDay = new MatchDay(matchNum);
        int indHome = matchDayNum;
        int indAway = indHome + 1;
        for (int i = 0; i < matchNum; i++) {
            boolean gameAdded = false;
            while (!gameAdded) {
                if (indHome == indAway) {
                    indHome += 1;
                }
                Team homeTeam = teams.get(indHome % 18);
                Team awayTeam = teams.get(indAway % 18);
                if (homeTeam == awayTeam) {
                    indHome += 1;
                    homeTeam = teams.get(indHome % 18);
                }
                Game testGame = new Game(homeTeam, awayTeam);
                try {
                    if (matchDay.teamIsPlaying(homeTeam)) {
                        throw new HomeTeamAlreadyPlaysException("This Team is already Playing this Matchday");
                    } else if (matchDay.teamIsPlaying(awayTeam)) {
                        throw new AwayTeamAlreadyPlaysException("This Team is already Playing this Matchday");
                    } else if (gameIsInFirstLeg(testGame)) {
                        throw new GameIsAlreadyPlayedException("This Teams are already Playing");
                    }
                    if ((homeTeam != null) && (awayTeam != null)) {
                        var game = matchDay.getGame(i);
                        game.addTeams(homeTeam, awayTeam);
                        indHome += 2;   // besser + 1 machen da sonst zu viel übersprungen?
                        indAway += 2;
                        this.gamesFirstLeg.add(game);
                        gameAdded = true;
                    }
                } catch (HomeTeamAlreadyPlaysException e) {
                    indHome += 1;
                } catch (AwayTeamAlreadyPlaysException | GameIsAlreadyPlayedException e) {
                    indAway += 1;
                }
            }
        }
        return matchDay;
    }

    public boolean gameIsInFirstLeg(Game testGame) {
        var testHomeTeam = testGame.getHomeTeam();
        var testAwayTeam = testGame.getAwayTeam();
        for (Game game : gamesFirstLeg) {
            var homeTeam = game.getHomeTeam();
            var awayTeam = game.getAwayTeam();
//           checks if teams have already playde in the first leg against each other
            if (((testHomeTeam == homeTeam) && (testAwayTeam == awayTeam)) || ((testHomeTeam == awayTeam) && (testAwayTeam == homeTeam))) {
                return true;
            }
        }
        return false;
    }
}