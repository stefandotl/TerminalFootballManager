package game;

import java.util.ArrayList;
import java.util.List;

public class LeagueTable {

    List<Team> table = new ArrayList<>();

    public LeagueTable(List<Team> table) {
        this.table = table;
    }

    public LeagueTable() {
        this.table = table;
    }

    public boolean hasTeams() {
        return table.size() > 0;
    }

    public void printTable() {
        for (Team team : table){
            String teamName = String.format("%-17s", team.getName());
            String gamesPlayed = String.format("%2s", team.getTeamScore().getGamesPlayed());
            String goalsScored = String.format("%2s", team.getTeamScore().getGoalsScored());
            String goalsConceded = String.format("%-2s", team.getTeamScore().getGoalsConceded());
            String points = String.format("%-2s", team.getTeamScore().getPoints());
            System.out.printf("%s %s.  %s : %s  %s \n", teamName, gamesPlayed,
                    goalsScored, goalsConceded, points);
        }

    }

    public void addTeam(Team team) {
        table.add(team);
    }
}
