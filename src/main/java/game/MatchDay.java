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
//        fixme: take the formatted String from printLeagueTable
        for (Game game : games) {
            String homeTeam = String.format("%-17s", game.getHomeTeam().getName());
            String awayTeam = String.format("%2s", game.getAwayTeam().getName());
            String scoreHomeTeam = String.format("%2s", game.getScoreHomeTeam());
            String scoreAwayTeam = String.format("%-2s", game.getScoreAwayTeam());
            System.out.printf("%s  %s : %s  %s \n", homeTeam, scoreHomeTeam,
                    scoreAwayTeam, awayTeam);
        }
    }
}
