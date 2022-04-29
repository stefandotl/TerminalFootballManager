package excpetions;

import org.slf4j.LoggerFactory;

public class TeamIsAlreadyPlayingException extends Exception {
    public TeamIsAlreadyPlayingException(String message) {
        LoggerFactory.getLogger(TeamIsAlreadyPlayingException.class.getName()).info(message);
    }
}
