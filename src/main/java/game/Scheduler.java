//package game;
//
//import java.util.*;
//
//public class Scheduler {
//    /** The schedule list. */
//    private Matches matches = new Matches();
//
//    public Scheduler(Teams participants) {
//        createSchedule(participants);
//    }
//
//    /** Creates the entire schedule
//     *
//     * @param participants List of participants for whom to create the schedule.
//     */
//    private void createSchedule(Teams participants) {
//        if (participants.getSize() % 2 == 1) {
//            // Number of teams uneven ->  add the bye team.
//            participants.addBye();
//        }
//
//        LinkedHashMap<Integer, Teams.Data> pList= participants.getList();
//        ArrayList list = new ArrayList();
//        // First, lets turn the LinkedHashMap into a list for easier manipulation
//        for (Iterator itr=pList.values().iterator();itr.hasNext();) {
//            list.add(itr.next());
//        }
//
//        for(int i = 1;i<list.size();i++) {
//            createOneRound(i, list);
//            // Move last item to first
//            list.add(1, list.get(list.size()-1));
//            list.remove(list.size()-1);
//        }
//
//    }
//
//    /** Creates one round, i.e. a set of matches where each team plays once.
//     *
//     * @param round Round number.
//     * @param list List of teams
//     */
//    private void createOneRound(int round, ArrayList teams) {
//        int mid = teams.size() / 2;
//        // Split list into two
//
//        ArrayList l1 = new ArrayList();
//        // Can't use sublist (can't cast it to ArrayList - how stupid is that)??
//        for(int j=0;j<mid;j++) {
//            l1.add(teams.get(j));
//        }
//
//        ArrayList l2 = new ArrayList();
//        // We need to reverse the other list
//        for(int j=teams.size()-1;j>=mid;j--) {
//            l2.add(teams.get(j));
//        }
//
//        for(int tId = 0;tId<l1.size();tId++) {
//            Teams.Data t1;
//            Teams.Data t2;
//            // Switch sides after each round
//            if (round %2 == 1) {
//                t1 = (Teams.Data)l1.get(tId);
//                t2 = (Teams.Data)l2.get(tId);
//            } else {
//                t1 = (Teams.Data)l2.get(tId);
//                t2 = (Teams.Data)l1.get(tId);
//            }
//            matches.addNew(round, ((round-1)*l1.size())+(tId+1), (String)t1.get("name"), (String)t2.get("name"));
//        }
//    }
//
//    /** Returns the match list (schedule)
//     */
//    public Matches get() {
//        return matches;
//    }
//}