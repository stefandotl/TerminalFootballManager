package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MatchDay {

    private List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        this.games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public void simulateGames() {
        games.forEach(Game::simulateRandomScore);
    }

    public boolean gamesHaveBeenPlayed() {
        return true;
    }

    public void printMatches() {
        for (Game game : games) {
            String homeTeam = game.getHomeTeam().getName();
            String awayTeam = game.getAwayTeam().getName();
            System.out.printf("%s : %s \n", homeTeam, awayTeam);
        }
//        Stream.of(games).forEach(x -> x.getHomeTeam().getName());
    }
}
