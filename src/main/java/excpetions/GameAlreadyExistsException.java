package excpetions;

import org.slf4j.LoggerFactory;

public class GameAlreadyExistsException extends Exception{
    public GameAlreadyExistsException(String s) {
        LoggerFactory.getLogger(GameAlreadyExistsException.class.getName()).info(s);
    }

    public GameAlreadyExistsException() {
        LoggerFactory.getLogger(GameAlreadyExistsException.class.getName()).info("This Game Already Exists");
    }
}
