package game;

import excpetions.NotEnoughTeamsException;

public class MainTest {
    public static void main(String[] args) throws NotEnoughTeamsException {
        Game game = new Game();
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");

        game.addTeams(kaiserslautern, dortmund);
        game.start();
        game.simulateRandomScore();
        game.end();
    }
}
