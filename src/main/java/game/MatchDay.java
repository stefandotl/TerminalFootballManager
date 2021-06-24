package game;

import excpetions.GameAlreadyExistsException;
import excpetions.TeamAlreadyExistsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchDay {

    private List<Game> games = new ArrayList<>();

    public MatchDay(int matches) {
        for (int i=0; i<matches; i++){
            Game game = new Game();
            games.add(game);
        }
    }

    public MatchDay() {
    }

    public void addGame(Game game) {
        try {
            if (games.contains(game)) {
                throw new GameAlreadyExistsException("Team is already playing this Matchday");
            } else {
                games.add(game);
            }
        } catch (GameAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public List<Game> getGames() {
        return games;
    }

    public Game getGame(int i) {
        return games.get(i);
    }

    public void simulateGames() {
        games.forEach(Game::simulateRandomScore);
    }

    public boolean gamesHaveBeenPlayed() {
        return true;
    }

    public void printMatchResults() {

        for (Game game : games) {
            String homeTeam = String.format("%-17s", game.getHomeTeam().getName());
            String awayTeam = String.format("%2s", game.getAwayTeam().getName());
            String scoreHomeTeam = String.format("%2s", game.getGoalsHomeTeam());
            String scoreAwayTeam = String.format("%-2s", game.getGoalsAwayTeam());
            System.out.printf("%s  %s : %s  %s \n", homeTeam, scoreHomeTeam,
                    scoreAwayTeam, awayTeam);
        }
    }

    public boolean teamIsPlaying(Team team) {
        var teamName = team.getName();
        for (Game game : games){
            if(game.getHomeTeam() == team || game.getAwayTeam() == team){
                return true;
            }
        }
        return false;
    }

    public void setGame(int index, Game game) {
        games.set(index, game);
    }
}
