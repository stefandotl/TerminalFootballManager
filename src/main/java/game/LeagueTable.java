package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeagueTable {

    List<TeamScore> table = new ArrayList<>();

    public boolean hasTeams() {
        return table.size() > 0;
    }

    public void printTable() {
        for (TeamScore teamScore : table){
            String teamName = String.format("%-13s", teamScore.getName());
            String gamesPlayed = String.format("%2s", teamScore.getGamesPlayed());
            String goalsScored = String.format("%2s", teamScore.getGoalsScored());
            String goalsConceded = String.format("%-2s", teamScore.getGoalsConceded());
            String points = String.format("%-2s", teamScore.getPoints());
            System.out.printf("%s %s.  %s : %s  %s \n", teamName, gamesPlayed,
                    goalsScored, goalsConceded, points);
        }

    }

    public void addTeam(TeamScore teamScore) {
        table.add(teamScore);
    }
}
