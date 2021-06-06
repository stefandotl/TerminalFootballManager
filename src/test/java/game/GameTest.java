package game;

import game.Game;
import game.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void startGame(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");

        assertThat(game.isRunning()).isFalse();
        game.addTeams(kaiserslautern, dortmund);
        game.start();
        assertThat(game.isRunning()).isTrue();
    }

    @Test
    @DisplayName("Game has ended")
    public void endGame(){
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
        assertThat(game.getScoreHomeTeam()).isEqualTo(1);
    }

    @Test
    @DisplayName("Away team scored")
    public void awayTeamScored(){
        game.awayTeamScored();
        game.awayTeamScored();
        game.awayTeamScored();
        assertThat(game.getScoreAwayTeam()).isEqualTo(3);
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
    public void simulateGame(){
        game.simulateRandomScore();
        assertThat(game.getScoreHomeTeam()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("Get Home Team")
    public void getHomeTeamFrom(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        assertThat(game.getHomeTeam()).isEqualTo(kaiserslautern);
    }

    @Test
    @DisplayName("Get Away Team")
    public void getAwayTeam(){
        Team kaiserslautern = new Team("1 FC Kaisersalutern");
        Team dortmund = new Team("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        assertThat(game.getAwayTeam()).isEqualTo(dortmund);
    }

    @Test
    @DisplayName("Points to Team are given")
    public void givePointsToTeamWithHomeTeamWins(){
        Team kaiserslautern = new TeamScore("1 FC Kaisersalutern");
        Team dortmund = new TeamScore("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.homeTeamScored();
        game.givePointsToTeam();
        assertThat(((TeamScore) kaiserslautern).getPoints()).isEqualTo(3);
        assertThat(((TeamScore) dortmund).getPoints()).isEqualTo(0);
    }

    @Test
    @DisplayName("Points to Team are given")
    public void givePointsToTeamWithDraw(){
        Team kaiserslautern = new TeamScore("1 FC Kaisersalutern");
        Team dortmund = new TeamScore("Borussia Dortmund");
        game.addTeams(kaiserslautern, dortmund);
        game.homeTeamScored();
        game.awayTeamScored();
        game.givePointsToTeam();
        assertThat(((TeamScore) dortmund).getPoints()).isEqualTo(1);
        assertThat(((TeamScore) kaiserslautern).getPoints()).isEqualTo(1);
    }

}
