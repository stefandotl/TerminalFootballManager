package game;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Team {

    @Id
    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamScore teamsScore;

    private int teamStrength;

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Player> players = new ArrayList<>();

    public Team() {
        name = "";
        this.teamsScore = new TeamScore();
    }

    public Team(String teamName) {
        this.name = teamName;
        this.teamsScore = new TeamScore(this.name);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasName() {
        return !name.isEmpty();
    }

//    public void addPlayer(Player player) {
//        players.add(player);
//    }

//    public int numberOfPlayers() {
//        return players.size();
//    }
//
//    public boolean hasEnoughPlayers() {
//        return players.size() >= 16;
//    }

    public boolean hasGoalKeeper() {
//        TODO: check if game.Team has a Goalkeeper
        return false;
    }

    public TeamScore getTeamScore() {
        return teamsScore;
    }

    public int getPoints() {
        return teamsScore.points;
    }

    public int getGoals() {
        return teamsScore.goalsScored;
    }

    public int getGoalDiffrence() {
        return teamsScore.goalsScored - teamsScore.goalsConceded;
    }
}
