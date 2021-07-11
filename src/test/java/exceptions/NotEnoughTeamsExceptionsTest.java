package exceptions;

import excpetions.NotEnoughTeamsException;
import game.Game;
import game.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotEnoughTeamsExceptionsTest {

    @Test
    @DisplayName("NotEnoughTeamsExceptions")
    public void notEnoughTeamsException() {
        assertThrows(NotEnoughTeamsException.class, () -> {
            Game game = new Game();
            game.start();
        });
    }

    @Test
    @DisplayName("NotEnoughTeamsExceptions not Thrown")
    public void notEnoughTeamsExceptionWontBeThrown() throws NotEnoughTeamsException {

        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        Game game = new Game();
        game.addTeams(kaiserslautern, dortmund);
        game.start();
        assertThat(game.isRunning()).isTrue();
    }
}