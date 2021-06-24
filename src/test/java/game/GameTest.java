package game;

import excpetions.ToManyTeamsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Game game;

    @BeforeEach
    void setUp(){
        this.game = new Game();
    }

    @Test
    @DisplayName("Game needs two Teams")
    public void gameNeedsTwoTeams(){

        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");

        game.addTeams(kaiserslautern, dortmund);

        assertThat(game.gameHasTwoTeams()).isTrue();
    }

    @Test
    @DisplayName("Game has started")
    public void startGame() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");

        game.addTeams(kaiserslautern, dortmund);
        assertThat(game.isRunning()).isFalse();
        game.start();
        assertThat(game.isRunning()).isTrue();
    }

    @Test
    @DisplayName("Game has ended")
    public void endGame() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.start();
        assertThat(game.isRunning()).isTrue();
        game.end();
        assertThat(game.isRunning()).isFalse();
    }

    @Test
    @DisplayName("Home team scored")
    public void homeTeamScored(){
        game.homeTeamScored();
        assertThat(game.getGoalsHomeTeam()).isEqualTo(1);
    }

    @Test
    @DisplayName("Away team scored")
    public void awayTeamScored(){
        game.awayTeamScored();
        game.awayTeamScored();
        game.awayTeamScored();
        assertThat(game.getGoalsAwayTeam()).isEqualTo(3);
    }

    @Test
    @DisplayName("Home game.Team wins")
    public void homeTeamWins(){
        game.homeTeamScored();
        game.homeTeamScored();
        game.awayTeamScored();
        assertThat(game.homeTeamWins()).isTrue();
    }

    @Test
    @DisplayName("Home game.Team wins")
    public void awayTeamWins(){
        game.homeTeamScored();
        game.homeTeamScored();
        game.awayTeamScored();
        assertThat(game.awayTeamWins()).isFalse();
    }

    @Test
    @DisplayName("Game ends draw")
    public void gameEndsDraw(){
        game.homeTeamScored();
        game.awayTeamScored();
        assertThat(game.gameEndsDraw()).isTrue();
    }

    @Test
    @DisplayName("Game has been simulated")
    public void simulateGame() {
        game.addTeams(new Team(), new Team());
        game.simulateRandomScore();
        assertThat(game.getGoalsHomeTeam()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("Get Home Team")
    public void getHomeTeamFrom() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        assertThat(game.getHomeTeam()).isEqualTo(kaiserslautern);
    }

    @Test
    @DisplayName("Get Away Team")
    public void getAwayTeam() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        assertThat(game.getAwayTeam()).isEqualTo(dortmund);
    }

    @Test
    @DisplayName("Points to Team are given")
    public void givePointsToTeamWithHomeTeamWins() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.homeTeamScored();
        game.givePointsToTeam(kaiserslautern, dortmund);
        assertThat(kaiserslautern.getTeamScore().getPoints()).isEqualTo(3);
        assertThat(dortmund.getTeamScore().getPoints()).isEqualTo(0);
    }

    @Test
    @DisplayName("Points to Team are given")
    public void givePointsToTeamWithDraw() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.homeTeamScored();
        game.awayTeamScored();
        game.givePointsToTeam(kaiserslautern, dortmund);
        assertThat(kaiserslautern.getTeamScore().getPoints()).isEqualTo(1);
        assertThat(dortmund.getTeamScore().getPoints()).isEqualTo(1);
    }

    @Test
    @DisplayName("Points to Team are given")
    public void givePointsToTeamWithSimulatedGame() {
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.homeTeamScored();
        game.awayTeamScored();
        game.givePointsToTeam(kaiserslautern, dortmund);
        assertThat(kaiserslautern.getTeamScore().getPoints()).isEqualTo(1);
        assertThat(dortmund.getTeamScore().getPoints()).isEqualTo(1);
    }

    @Test
    @DisplayName("Get Home Team is Null")
    public void getHomeTeam(){
        Game game = new Game();
        assertThat(game.getHomeTeam()).isEqualTo(null);
    }

    @Test()
    @DisplayName("Cant add more then two teams and throw excpetion")
    public void cantAddMoreThanTwoTeamsToAGame(){
        assertThrows(ToManyTeamsException.class, () -> {
            Game game = new Game();
            Team kaiserslautern = new Team("1 FC Kaisersalutern");
            Team dortmund = new Team("Borussia Dortmund");
            game.addTeam(kaiserslautern);
            game.addTeam(dortmund);
            game.addTeam(kaiserslautern);
        });
    }

    @Test
    public void addHomeAndAwayTeam() {
        Game game = new Game();
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addHomeTeam(kaiserslautern);
        assertThat(game.getHomeTeam()).isEqualTo(kaiserslautern);
        game.addAwayTeam(dortmund);
        assertThat(game.getAwayTeam()).isEqualTo(dortmund);
    }

}
