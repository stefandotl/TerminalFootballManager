package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LeagueTableTest {

    @Test
    @DisplayName("LeagueTableHasTeams")
    void LeagueTableHasTeams(){
        TeamScore teamScore = new TeamScore("Liverpool");
        LeagueTable leagueTable = new LeagueTable();
        leagueTable.addTeam(teamScore);
        assertThat(leagueTable.hasTeams()).isTrue();
    }



    @Test
    @DisplayName("Table can be printed")
    void tableCanBePrinted(){
//        fixme: make this to a Stream
        List<String> teams = Arrays.asList("Liverpool", "Dortmund", "Schalke", "Hamburg", "Bayern", "Kaiserslautern");
        TeamScore teamScore = new TeamScore("Liverpool");
        TeamScore teamScore2 = new TeamScore("BVB");
        TeamScore teamScore3 = new TeamScore("Bremen");
        TeamScore teamScore4 = new TeamScore("Schalke");
        TeamScore teamScore5 = new TeamScore("Bayern");
        LeagueTable leagueTable = new LeagueTable();
        teamScore.add3Points();
        teamScore.addGame();
        teamScore.addGoals(3);
        teamScore.add3Points();
        leagueTable.addTeam(teamScore);
        leagueTable.addTeam(teamScore2);
        leagueTable.addTeam(teamScore3);
        leagueTable.addTeam(teamScore4);
        leagueTable.addTeam(teamScore5);
        leagueTable.printTable();
    }

    @Test
    @DisplayName("Get teams from file to league")
    void getTeamsToLeague(){
        LeagueTable leagueTable = new LeagueTable();
        assertThat(leagueTable.hasTeams()).isTrue();
    }

}
