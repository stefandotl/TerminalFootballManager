package game;

import java.util.ArrayList;
import java.util.List;

public class MatchDay {

    private List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        this.games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }
}
