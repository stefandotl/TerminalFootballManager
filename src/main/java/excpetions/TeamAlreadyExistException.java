package excpetions;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class TeamAlreadyExistException extends Exception {
    public TeamAlreadyExistException(String message) {
        LoggerFactory.getLogger(TeamAlreadyExistException.class.getName()).error(message);
    }

    public TeamAlreadyExistException() {
        LoggerFactory.getLogger(TeamAlreadyExistException.class.getName()).error("This Team Already Exists");

    }
}
