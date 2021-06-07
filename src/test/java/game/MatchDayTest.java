package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchDayTest {

    @Test
    @DisplayName("Add game to matchday")
    public void addGameToMatchday(){
        MatchDay matchday = new MatchDay();
        Team team1 = new Team("Hamburg");
        Team team2 = new Team("dortmund");
        Game game = new Game();
        game.addTeams(team1, team2);
        matchday.addGame(game);
        assertThat(matchday.getGames().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Simulate Matchday")
    public void simulateMatchDay(){
        MatchDay matchday = new MatchDay();
        Team team1 = new Team("Hamburg");
        Team team2 = new Team("dortmund");
        Team team3 = new Team("Bremen");
        Team team4 = new Team("Schalke");
        Game game = new Game();
        Game game2 = new Game();
        game.addTeams(team1, team2);
        game2.addTeams(team3, team4);
        matchday.addGame(game);
        matchday.addGame(game2);
        matchday.simulateGames();
        assertThat(matchday.gamesHaveBeenPlayed()).isTrue();
    }

    @Test
    @DisplayName("Print Matchday")
    public void printMatchday(){
        Bundesliga bundesliga = new Bundesliga();
        var matchDay = bundesliga.generateMatches();
        matchDay.printMatches();
    }

}
