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
        var matchDay = season.getMatchday(0);
        matchDay.simulateGames();
        season.printTable();
        assertThat(matchDay.getGames().size()).isEqualTo(9);
    }

    @Test
    @DisplayName("Generate Matchday")
    public void generateMatchday() throws Exception {
        Season season = new Season();
        season.generateMatchdays();
        List<MatchDay> matchDayList = season.getAllMatchdays();
        int matchdayIndex = 1;
        for (MatchDay matchDay : matchDayList){
            matchDay.simulateGames();
            System.out.printf("-----" + matchdayIndex +"-------\n");
            matchDay.printMatchResults();
            matchdayIndex++;
        }
//        assertThat(season.getListMatchDays().size()).isEqualTo(34);
    }
}
