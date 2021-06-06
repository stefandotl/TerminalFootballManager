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
//        fixme: either as for loop or as stream
        games.forEach(Game::simulateRandomScore);
    }

    public boolean gamesHaveBeenPlayed() {
        return true;
    }
}
