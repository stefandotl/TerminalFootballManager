package excpetions;

import org.slf4j.LoggerFactory;

public class ToManyTeamsException extends Exception {

    public ToManyTeamsException() {
        LoggerFactory.getLogger(ToManyTeamsException.class.getName()).info("Your game has already 2 teams. You can't add teams anymore.");
    }
}
