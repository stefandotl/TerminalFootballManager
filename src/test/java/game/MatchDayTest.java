package game;

import excpetions.TeamIsAlreadyPlayingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchDayTest {

    @Test
    @DisplayName("Add game to matchday")
    public void addGameToMatchday() throws Exception {
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
    public void simulateMatchDay() throws Exception {
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
    @DisplayName("Team is already in playing this matchday")
    public void teamIsPlayingThisMatchDay() throws Exception {
        MatchDay matchDay = new MatchDay();
        Team dortmund = new Team("Dortmund");
        Team koeln  = new Team("Koeln");
        Game game = new Game(dortmund, koeln);
        matchDay.addGame(game);
        assertThat(matchDay.teamIsPlaying(koeln)).isTrue();
    }

    @Test
    @DisplayName("Cant Add a Game with a playing team")
    public void cantAddAGameWithAPlayingTeam() throws Exception {
        assertThrows(TeamIsAlreadyPlayingException.class, ()->{
            MatchDay matchDay = new MatchDay();
            Team dortmund = new Team("Dortmund");
            Team koeln  = new Team("Koeln");
            Game game = new Game(dortmund, koeln);
            matchDay.addGame(game);
            matchDay.addGame(game);
        });
    }

    @Test
    @DisplayName("Add Game and throw game already exists exception")
    public void addGameWithException() {
        assertThrows(TeamIsAlreadyPlayingException.class, () -> {
            MatchDay matchDay = new MatchDay();
            Team kaiserslautern = new Team("Kaiserslautern");
            Team dortmund = new Team("Dortmund");
            var game1 = new Game();
            var game2 = new Game();
            game1.addTeams(kaiserslautern, dortmund);
            game2.addTeams(kaiserslautern, dortmund);
            matchDay.addGame(game1);
            matchDay.addGame(game2);
        });
    }
}
