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
        Team team = new Team("Liverpool");
        LeagueTable leagueTable = new LeagueTable();
        leagueTable.addTeam(team);
        assertThat(leagueTable.hasTeams()).isTrue();
    }



    @Test
    @DisplayName("Table can be printed")
    void tableCanBePrinted(){

        List<String> teams = Arrays.asList("Liverpool", "Dortmund", "Schalke", "Hamburg", "Bayern", "Kaiserslautern");
        Team team = new Team("Liverpool");
        Team team2 = new Team("BVB");
        Team team3 = new Team("Bremen");
        Team team4 = new Team("Schalke");
        Team team5 = new Team("Bayern");
        LeagueTable leagueTable = new LeagueTable();
        team.getTeamScore().add3Points();
        team.getTeamScore().addGame();
        team.getTeamScore().addGoals(3);
        team.getTeamScore().add3Points();
        leagueTable.addTeam(team);
        leagueTable.addTeam(team2);
        leagueTable.addTeam(team3);
        leagueTable.addTeam(team4);
        leagueTable.addTeam(team5);
//        leagueTable.printTable();
    }

//    @Test
//    @DisplayName("Get teams from file to league")
//    void getTeamsToLeague() {
//        LeagueTable leagueTable = new LeagueTable();
//        Season season = new Season();
//        var matchDay = season.generateMatchday(0);
//        matchDay.simulateGames();
//        leagueTable.printTable();
//        assertThat(season.hasEnoughTeams()).isTrue();
//    }

//    @Test
//    @DisplayName("Sort the Table")
//    public void printTable() {
//        Season season = new Season();
//        var matchDay = season.generateMatchday(0);
//        matchDay.simulateGames();
//        matchDay.printMatchResults();
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        season.printTable();
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        var matchDay2 = season.generateMatchday(0);
//        matchDay2.simulateGames();
//        matchDay2.printMatchResults();
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        System.out.println("-----------------------------------");
//        season.printTable();
//    }
}
