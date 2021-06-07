package excpetions;

import java.util.logging.Logger;

public class TeamNumberNotEqualTwoException extends Exception {
    public TeamNumberNotEqualTwoException(String message){
        Logger log = Logger.getLogger(TeamNumberNotEqualTwoException.class.getName());
        log.warning(message);
    }

    public TeamNumberNotEqualTwoException(){
        Logger log = Logger.getLogger(TeamNumberNotEqualTwoException.class.getName());
        log.warning("Your game needs exactly two teams!");
    }
}
