package logging;

import java.util.logging.Logger;

public class ConsoleLogger extends AbstractLogger {

    private Logger logger = Logger.getGlobal();

    public ConsoleLogger(boolean isVerboseOn) {
        super(isVerboseOn);
    }

    @Override
    public void log(Level level, String message) {
        //TODO
        System.out.println("inside ConsoleLogger with verbose mode: " + (isVerboseOn() ? "on" : "off"));

        boolean isLevelForVerbose = level.equals(Level.DEBUG) || level.equals(Level.WARNING);

        if (isVerboseOn() && isLevelForVerbose) {
            System.out.println("Logging for level " + level.toString());
        } else if ((isVerboseOn() && !isLevelForVerbose) || (!isVerboseOn() && !isLevelForVerbose)) {
            System.out.println("Logging for level " + level.toString());
        }

    }
}