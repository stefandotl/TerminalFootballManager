package game;

import game.Team;
import game.TeamScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamScoreTest {

    @Test
    @DisplayName("3 Points added")
    void threePointsAdded(){
        TeamScore team = new TeamScore("Kaiserslautern");
        team.add3Points();
        assertThat(team.getPoints()).isEqualTo(3);
    }

    @Test
    @DisplayName("1 and 3 Points added")
    void oneAndTreePointsAdded(){
        TeamScore team = new TeamScore("Kaiserslautern");
        team.add1Point();
        team.add3Points();
        assertThat(team.getPoints()).isEqualTo(4);
    }

    @Test
    @DisplayName("1 played Game added")
    void addGame(){
        TeamScore team = new TeamScore("Kaiserslautern");
        team.addGame();
        assertThat(team.getGamesPlayed()).isEqualTo(1);
    }

}
