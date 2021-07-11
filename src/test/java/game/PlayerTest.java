package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

//    @BeforeEach
//    void setUp(){
//        Player player = new game.Player();
//    }

    @Test
    public void playerHasName(){
        Player player = new Player("Christiano Ronaldo");

        assertThat(player.hasName()).isTrue();
    }

    @Test
    public void positionOfPlayer(){
        Player player = new Player("Christiano Ronaldo");
//        player.setPosition(gk);

        assertThat(player.hasName()).isTrue();
    }

    @Test
    public void getTeamFromPlayer(){
        Player player = new Player("Christiano Ronaldo");
        Team team = new Team("Man U");
        team.addPlayer(player);
        String retreivedTeam = player.getTeam();
        assertThat(retreivedTeam).isEqualTo(team.getName());
    }
}
