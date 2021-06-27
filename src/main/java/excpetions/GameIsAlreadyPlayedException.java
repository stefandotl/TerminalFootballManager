package excpetions;

import org.slf4j.LoggerFactory;

public class GameIsAlreadyPlayedException extends Exception {
    public GameIsAlreadyPlayedException(String s) {
        LoggerFactory.getLogger(GameIsAlreadyPlayedException.class.getName()).info(s);
    }

    public GameIsAlreadyPlayedException() {
        LoggerFactory.getLogger(GameIsAlreadyPlayedException.class.getName()).info("Game is already played this leg");
    }
}
