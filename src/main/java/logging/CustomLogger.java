package logging;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CustomLogger {

    private static Logger logger = null;


    private CustomLogger() {}

    public static Logger getLogger() {
        if(Objects.isNull(logger)) {
            logger = LoggerFactory.getLogger();
        }
        return logger;
    }









}
