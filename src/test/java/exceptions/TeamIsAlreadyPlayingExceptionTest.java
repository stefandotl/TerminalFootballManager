package exceptions;

import game.Game;
import game.Team;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TeamIsAlreadyPlayingExceptionTest {

    @Test()
    public void CantAddTheSameTeamTwice(){
        Game game = new Game();
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, kaiserslautern);
        assertThat(game.getHomeTeam()).isNotEqualTo(kaiserslautern);
    }

}
