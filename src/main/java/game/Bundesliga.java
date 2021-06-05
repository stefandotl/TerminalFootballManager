package game;

import java.util.HashSet;
import java.util.Set;

public class Bundesliga {

    Set<Team> teams = new HashSet<>();

    private int teamStrength;

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean hasEnoughTeams() {
        return teams.size() == 18;
    }

    public void generateTeams() {
        Team team = new Team("BVB");
    }
}
