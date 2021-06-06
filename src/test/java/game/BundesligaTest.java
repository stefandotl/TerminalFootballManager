package game;

import game.Bundesliga;
import game.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BundesligaTest {

    Bundesliga bundesliga;

    @BeforeEach
    public void setUp(){
        this.bundesliga = new Bundesliga();
    }

    @Test
    @DisplayName("Team Has Been Added")
    public void teamHasBeenAdded(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");

        bundesliga.addTeam(kaiserslautern);
    }

    @Test
    @DisplayName("League has not enough Teams")
    public void notEnoughTeams(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        bundesliga.addTeam(kaiserslautern);
        bundesliga.addTeam(kaiserslautern);

        assertThat(bundesliga.hasEnoughTeams()).isFalse();
    }

    @Test
    @DisplayName("18 Teams Generated")
    public void generateTeams(){
        Bundesliga bundesliga = new Bundesliga();
        bundesliga.generateTeams();
        assertThat(bundesliga.numberOfTeams()).isEqualTo(18);
    }

    @Test
    @DisplayName("Generate Game")
    public void generateGame(){
        Bundesliga bundesliga = new Bundesliga();
        bundesliga.generateTeams();
        var matchDay = bundesliga.generateMatches();
        assertThat(matchDay.getGames().size()).isEqualTo(9);
    }
}
