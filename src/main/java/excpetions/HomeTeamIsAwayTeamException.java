package excpetions;

import org.slf4j.LoggerFactory;

public class HomeTeamIsAwayTeamException extends Throwable {

    public HomeTeamIsAwayTeamException() {
        LoggerFactory.getLogger(HomeTeamIsAwayTeamException.class.getName()).info("Hometeam is Awayteam");
    }
}
