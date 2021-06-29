package game;

import excpetions.ToManyTeamsException;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STREAM;

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
        var matchDay = season.getMatchday(0);
        matchDay.simulateGames();
        season.printTable();
        assertThat(matchDay.getGames().size()).isEqualTo(9);
        System.out.println("---------------");
        season.printTable();
    }

    @Test
    @DisplayName("GenerateMatchDay V3")
    public void generateMatchDayV3(){
        Season season = new Season();
        var matchdays = season.getListMatchDays();
        int i = 1;
        for (MatchDay matchDay : matchdays){
            System.out.println(i);
            matchDay.simulateGames();
            matchDay.printMatchResults();
            System.out.println("------------------");
            i++;
        }
        season.printTable();
    }
}
