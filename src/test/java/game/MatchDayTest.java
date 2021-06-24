package game;

import excpetions.GameAlreadyExistsException;
import excpetions.TeamAlreadyExistsException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MatchDayTest {

    @Test
    @DisplayName("Add game to matchday")
    public void addGameToMatchday() {
        MatchDay matchday = new MatchDay();
        Team team1 = new Team("Hamburg");
        Team team2 = new Team("dortmund");
        Game game = new Game();
        game.addTeams(team1, team2);
        matchday.addGame(game);
        assertThat(matchday.getGames().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Constructed MatchDay has 9 games")
    public void createMatchDayWithGames(){
        MatchDay matchday = new MatchDay(9);
        assertThat(matchday.getGames().size()).isEqualTo(9);
    }

    @Test
    @DisplayName("Simulate Matchday")
    public void simulateMatchDay() {
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
    public void printMatchday() {
        Season season = new Season();
        var matchDay = season.getMatchday(0);
        matchDay.printMatchResults();
    }

    @Test
    @DisplayName("Print Matchday with random Score")
    public void printMatchdayWithRandomScore() {
        Season season = new Season();
        var matchDay = season.getMatchday(0);
        matchDay.simulateGames();
        matchDay.printMatchResults();
    }
    
    @Test
    @DisplayName("Print Matchday with random Score")
    public void getMatchdayWithRandomScore() {
        Season season = new Season();
        var matchDay = season.getMatchday(0);
        matchDay.simulateGames();
        List<Game> games = matchDay.getGames();
        assertThat(games.get(0).getGoalsHomeTeam()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("Team is already in playing this matchday")
    public void teamIsPlayingThisMatchDay(){
        MatchDay matchDay = new MatchDay();
        Team dortmund = new Team("Dortmund");
        Team koeln  = new Team("Koeln");
        Game game = new Game(dortmund, koeln);
        matchDay.addGame(game);
        assertThat(matchDay.teamIsPlaying(koeln)).isTrue();
    }

    @Test
    @DisplayName("Cant Add a Game with a playing team")
    public void cantAddAGameWithAPlayingTeam() {
        MatchDay matchDay = new MatchDay();
        Team dortmund = new Team("Dortmund");
        Team koeln  = new Team("Koeln");
        Game game = new Game(dortmund, koeln);
        matchDay.addGame(game);
        matchDay.addGame(game);
        assertThat(matchDay.getGames().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Print Matchday with random Score")
    public void teamPlaysThisMatchDay() {
        Season season = new Season();
        var matchDay = season.generateMatchday();
        matchDay.simulateGames();
        matchDay.printMatchResults();
    }
}
