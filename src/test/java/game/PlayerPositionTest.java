package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerPositionTest {

    PlayerPosition pos;

    @Test
    @DisplayName("Player has Set Position")
    public void setAndGetPosition() {
        Player player = new Player("Christiano Ronaldo");
        Player player2 = new Player("Lionel Messi", PlayerPosition.ST);
        Player player3 = new Player("Lionel Messi", PlayerPosition.CM, PlayerPosition.RWS);
        Player player4 = new Player("Lionel Messi", PlayerPosition.CB, PlayerPosition.LB, PlayerPosition.RB);
        Player player5 = new Player("Lionel Messi", PlayerPosition.DMF, PlayerPosition.GK, PlayerPosition.OFM, PlayerPosition.CM);
        player.setPosition(PlayerPosition.ST);

        var position = player.getPosition();

        assertThat(player.getPosition()).isEqualTo(PlayerPosition.ST);
    }
}
