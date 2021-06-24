package excpetions;

import org.slf4j.LoggerFactory;

public class GameAlreadyExistsException extends Exception{
    public GameAlreadyExistsException(String s) {
        LoggerFactory.getLogger(GameAlreadyExistsException.class.getName()).error(s);
    }

    public GameAlreadyExistsException() {
        LoggerFactory.getLogger(GameAlreadyExistsException.class.getName()).error("This Game Already Exists");
    }
}
