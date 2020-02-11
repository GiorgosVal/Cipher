package logging;

public class DatabaseLogger extends AbstractLogger {

    public DatabaseLogger(boolean isVerboseOn) {
        super(isVerboseOn);
    }

    @Override
    public void log(Level level, String message) {
        //TODO
        System.out.println("inside DatabaseLogger with verbose mode: " + (isVerboseOn() ? "on" : "off"));
    }
}
