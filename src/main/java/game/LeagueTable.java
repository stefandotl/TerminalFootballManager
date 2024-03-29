package game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        this.table = sortTable();
        int counter = 1;
        for (Team team : table){
            String placeTable = String.format("%2s.", counter);
            String teamName = String.format("%-17s", team.getName());
            String gamesPlayed = String.format("%2s", team.getTeamScore().getGamesPlayed());
            String goalsScored = String.format("%2s", team.getTeamScore().getGoalsScored());
            String goalsConceded = String.format("%-2s", team.getTeamScore().getGoalsConceded());
            String points = String.format("%-2s", team.getTeamScore().getPoints());
            counter++;
            System.out.printf("%s %s %s.  %s : %s  %s \n", placeTable, teamName, gamesPlayed,
                    goalsScored, goalsConceded, points);
        }

    }

    public List<Team> sortTable(){

        Comparator<Team> pointsComparator = Comparator.comparing(Team::getPoints);
        Comparator<Team> goalDiffrenceComparator = Comparator.comparing(Team::getGoalDiffrence);
        Comparator<Team> goalsComparator = Comparator.comparing(Team::getGoals);

        Comparator<Team> allComparator = pointsComparator.thenComparing(goalDiffrenceComparator)
                                                        .thenComparing(goalsComparator);

        List<Team> sortedTable = table.stream()
                .sorted(allComparator.reversed())
                .collect(Collectors.toList());

        return sortedTable;
    }

    public void addTeam(Team team) {
        table.add(team);
    }
}
