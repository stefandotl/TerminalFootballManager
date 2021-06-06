package exceptions;

import game.Game;
import game.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotEnoughTeamsExceptionsTest {

    @Test
    @DisplayName("NotEnoughTeamsExceptions")
    public void notEnoughTeamsException() {

        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        Game game = new Game();
        game.start();
        assertThat(game.isRunning()).isFalse();
    }

    @Test
    @DisplayName("NotEnoughTeamsExceptions")
    public void notEnoughTeamsExceptionWontBeThrown() {

        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        Game game = new Game();
        game.addTeams(kaiserslautern, dortmund);
        game.start();
        assertThat(game.isRunning()).isTrue();
        game.end();
    }
}