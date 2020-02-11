package logging;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract class AbstractLogger implements Logger {

    private boolean isVerboseOn;

    public AbstractLogger(boolean isVerboseOn) {
        this.isVerboseOn = isVerboseOn;
    }

}
