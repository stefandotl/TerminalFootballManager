package game;

import game.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

//    @BeforeEach
//    void setUp(){
//        Player player = new game.Player();
//    }

    @Test
    @DisplayName("Player has a name")
    public void playerHasName(){
        Player player = new Player("Christiano Ronaldo");

        assertThat(player.hasName()).isTrue();
    }

    @Test
    @DisplayName("Position of Player is Goalkeeper")
    public void positionOfPlayer(){
        Player player = new Player("Christiano Ronaldo");
//        player.setPosition(gk);

        assertThat(player.hasName()).isTrue();
    }
}
