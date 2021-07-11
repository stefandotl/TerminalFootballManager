package excpetions;

import org.slf4j.LoggerFactory;

public class NotEnoughTeamsException extends Exception {
    public NotEnoughTeamsException(){
        LoggerFactory.getLogger(NotEnoughTeamsException.class.getName()).info("Your game needs exactly two teams!");
    }
}
