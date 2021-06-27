package excpetions;

import org.slf4j.LoggerFactory;

public class AwayTeamAlreadyPlaysException extends Exception {
    public AwayTeamAlreadyPlaysException(String s) {
        LoggerFactory.getLogger(AwayTeamAlreadyPlaysException.class.getName()).info(s);
    }

    public AwayTeamAlreadyPlaysException() {
        LoggerFactory.getLogger(AwayTeamAlreadyPlaysException.class.getName()).info("Away Team is Already playing");
    }
}
