package game;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.*;

public class Team {

    public String name;

    private TeamScore teamsScore;

    private int teamStrength;

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }

//    @Column(name = "PLAYERS")
    private List<Player> players = new ArrayList<>();

    public Team() {
        name = "";
        this.teamsScore = new TeamScore();
    }

    public Team(String teamName) {
        this.name = teamName;
        this.teamsScore = new TeamScore();
    }

    public String getName() {
        return name;
    }

    public String getId() {
//        TODO: check which id you want, a name as id or a unique long id
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasName() {
        return !name.isEmpty();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public boolean hasEnoughPlayers() {
        return players.size() >= 16;
    }

    public boolean hasGoalKeeper() {
//        TODO: check if game.Team has a Goalkeeper
        return false;
    }

    public TeamScore getTeamScore() {
        return teamsScore;
    }
}
