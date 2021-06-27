package excpetions;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class NotEnoughTeamsException extends Exception {
    public NotEnoughTeamsException(String message){
        LoggerFactory.getLogger(NotEnoughTeamsException.class.getName()).info(message);

    }
    public NotEnoughTeamsException(){
        LoggerFactory.getLogger(NotEnoughTeamsException.class.getName()).info("Your game needs exactly two teams!");
    }
}
