package excpetions;

import org.slf4j.LoggerFactory;

public class HomeTeamAlreadyPlaysException extends Exception {
    public HomeTeamAlreadyPlaysException(String s) {
        LoggerFactory.getLogger(HomeTeamAlreadyPlaysException.class.getName()).info(s);
    }

    public HomeTeamAlreadyPlaysException() {
        LoggerFactory.getLogger(HomeTeamAlreadyPlaysException.class.getName()).info("Hometeam is already playing");
    }
}
