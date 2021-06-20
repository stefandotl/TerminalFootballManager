package exceptions;

import excpetions.TeamAlreadyExistException;
import game.Game;
import game.Team;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamAlreadyExistsExceptionTest {



    @Test()
    public void CantAddTheSameTeamTwice(){


        Game game = new Game();
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, kaiserslautern);
    }

}
