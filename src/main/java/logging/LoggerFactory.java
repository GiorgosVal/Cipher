package logging;

import options.Option;
import options.OptionsLoader;

import java.util.HashMap;

public class LoggerFactory {

    public static Logger getLogger() {

        OptionsLoader optionsLoader = OptionsLoader.getOptionsLoader();
        boolean isVerboseOn = optionsLoader.getOptions().containsKey(Option.V) || optionsLoader.getOptions().containsKey(Option.VERBOSE);
        String output = "";   //TODO this must be the result of the selected output, after loading configuration file and explicit options
        switch (output) {
            case "db":
                return new DatabaseLogger(isVerboseOn);
            case "text":
                return new FileLogger(isVerboseOn);
            default:
                return new ConsoleLogger(isVerboseOn);
        }
    }

}
