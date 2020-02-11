package logging;

public class FileLogger extends AbstractLogger {

    public FileLogger(boolean isVerboseOn) {
        super(isVerboseOn);
    }

    @Override
    public void log(Level level, String message) {
        //TODO
        System.out.println("inside FileLogger with verbose mode: " + (isVerboseOn() ? "on" : "off"));
    }
}
