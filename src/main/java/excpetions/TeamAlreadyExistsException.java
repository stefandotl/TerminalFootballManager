package excpetions;

import org.slf4j.LoggerFactory;

public class TeamAlreadyExistsException extends Exception {
    public TeamAlreadyExistsException(String message) {
        LoggerFactory.getLogger(TeamAlreadyExistsException.class.getName()).error(message);
    }

    public TeamAlreadyExistsException() {
        LoggerFactory.getLogger(TeamAlreadyExistsException.class.getName()).error("This Team Already Exists");
    }
}
