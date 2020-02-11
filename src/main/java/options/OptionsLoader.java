package options;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.logging.Logger;

import static java.util.Objects.*;
import static utils.ArrayUtils.isNotLast;

@Getter
@Setter

//TODO must be turned into Signleton
public class OptionsLoader {

    public Map<Option, String> options;
    private static OptionsLoader optionsLoader = null;

    private OptionsLoader(){}

    private OptionsLoader(Map<Option, String> options) {
        setOptions(options);
    }

    public static OptionsLoader getOptionsLoader() {
        if (Objects.isNull(optionsLoader)) {
            optionsLoader = new OptionsLoader(new HashMap<>());
        }
        return optionsLoader;
    }

    public Map<Option, String> loadOptions(String[] args) {
        for (int i = 0; i < args.length; i++) {
            Option option = Option.createOption(args[i]);
            String value = null;
            boolean optionNotPresent = !isNull(option) && !isRelativeOptionPresent(option, this.options);
            boolean optionPresent = !isNull(option) && isRelativeOptionPresent(option, this.options);
            if(optionNotPresent) {

                if (option.isAcceptingValue() && isNotLast(i, args) && !Option.isOption(args[i + 1])) {
                    value = args[i + 1];
                    i++;
                }
                this.options.put(option, value);
                System.out.println("Added option " + option.getOption() + " with value " + value);
            } else if (optionPresent) {
                System.out.println("Option " + option.getOption() + " is already present.");
            } else {
                System.out.println("Not valid option: " + args[i]);
            }
        }
        return this.options;
    }


    private boolean isRelativeOptionPresent(Option option, Map<Option, String> options) {
        List<Option> relativeOptions = Option.getRelativeOptions(option);
        for (Option relevant : relativeOptions) {
            if (options.containsKey(relevant)) {
                return true;
            }
        }
        return false;
    }







}
