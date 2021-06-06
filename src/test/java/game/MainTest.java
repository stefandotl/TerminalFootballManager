package game;

import excpetions.TeamNumberNotEqualTwoException;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    public static void main(String[] args) throws TeamNumberNotEqualTwoException {
        Game game = new Game();
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");

        game.addTeams(kaiserslautern, dortmund);
        game.start();
        game.homeTeamScored();
        game.homeTeamScored();
        game.awayTeamScored();
        game.end();
        game.printScore();
    }
}
