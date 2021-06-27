package game;

import excpetions.ToManyTeamsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeasonTest {

    Season season;

    @BeforeEach
    public void setUp() {
        this.season = new Season();
    }

    @Test
    @DisplayName("Team Has Been Added")
    public void teamHasBeenAdded(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");

        season.addTeam(kaiserslautern);
    }

    @Test
    @DisplayName("League has not enough Teams")
    public void notEnoughTeams(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Season season1 = new Season(false);
        season1.addTeam(kaiserslautern);
        season1.addTeam(kaiserslautern);

        assertThat(season1.hasEnoughTeams()).isFalse();
    }

    @Test
    @DisplayName("18 Teams Generated")
    public void generateTeams() {
        Season season = new Season();
        assertThat(season.teams.size()).isEqualTo(18);
    }

    @Test
    @DisplayName("Generate Game")
    public void generateGame() {
        Season season = new Season();
        var matchDay = season.getMatchday(0);
        assertThat(matchDay.getGames().size()).isEqualTo(9);
    }

    @Test
    @DisplayName("print Table")
    public void printTable() {
        Season season = new Season();
        var matchDay = season.generateMatchday(0);
        matchDay.simulateGames();
        season.printTable();
        assertThat(matchDay.getGames().size()).isEqualTo(9);
    }

    @Test
    @DisplayName("Generate Several Matchdays")
    public void generateMatchDayNewVersion() {
        Season season = new Season();
        var matchDay = season.generateMatchday(0);
        matchDay.simulateGames();
        var matchDay2 = season.generateMatchday(1);
        matchDay2.simulateGames();
        var matchDay3 = season.generateMatchday(2);
        matchDay3.simulateGames();
        matchDay.printMatchResults();
        System.out.println("----------");
        matchDay2.printMatchResults();
        System.out.println("----------");
        matchDay3.printMatchResults();
    }
}
