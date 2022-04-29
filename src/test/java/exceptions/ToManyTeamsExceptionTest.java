package exceptions;

import excpetions.ToManyTeamsException;
import game.Game;
import game.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToManyTeamsExceptionTest {
    @Test
    @DisplayName("To Many Teams exceptions is thrown")
    public void toManyTeamsExceptionIsThrown(){
        assertThrows(ToManyTeamsException.class, () ->{
            Game game = new Game();
            Team kaiserslautern = new Team("1 FC Kaisersalutern");
            Team dortmund = new Team("Borussia Dortmund");
            Team berlin = new Team("Union Berlin");
            game.addTeam(kaiserslautern);
            game.addTeam(dortmund);
            game.addTeam(berlin);
            }
        );
    }

}
