package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {

    Team team;

    @BeforeEach
    void setUp(){
        this.team = new Team("Borussia Dortmund");
    }

    @Test
    @DisplayName("Team has a Name")
    public void teamHasName(){
        assertThat(team.hasName()).isTrue();
    }

//    @Test
//    @DisplayName("Player has been added")
//    public void playerHasBeenAdded(){
//        Player player = new Player();
//        team.addPlayer(player);
//        team.addPlayer(player);
//        team.addPlayer(player);
//        team.addPlayer(player);
//        assertThat(team.numberOfPlayers()).isEqualTo(4);
//    }
//
//    @Test
//    @DisplayName("Has enough Players")
//    void hasEnoughPlayers(){
//        Player player = new Player();
//        team.addPlayer(player);
//        assertThat(team.hasEnoughPlayers()).isFalse();
//    }
//
//    @Test
//    @DisplayName("Team has at least a goalkeeper")
//    void teamHasAtLeastAGoalKeeper(){
//        Player player = new Player();
//        team.addPlayer(player);
//        assertThat(team.hasGoalKeeper()).isFalse();
//    }
//
//    @Test
//    @DisplayName("Get Team Score")
//    void getTeamScore(){
//        Player player = new Player();
//        team.addPlayer(player);
//        assertThat(team.hasGoalKeeper()).isFalse();
//    }

}