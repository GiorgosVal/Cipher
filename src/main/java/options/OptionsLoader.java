package options;

import java.util.*;
import static java.util.Objects.*;
import static utils.ArrayUtils.isNotLast;

public class OptionsLoader {


    public Map<Option, String> options = new HashMap<>();

    public Map<Option, String> getOptions () {
        return this.options;
    }

    public void loadOptions(String[] args) {
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
                options.put(option, value);
                System.out.println("Added option " + option.getOption() + " with value " + value);
            } else if (optionPresent) {
                System.out.println("Option " + option.getOption() + " is already present.");
            } else {
                System.out.println("Not valid option: " + args[i]);
            }
        }

    }

    public boolean isRelativeOptionPresent(Option option, Map<Option, String> options) {
        List<Option> relativeOptions = Option.getRelativeOptions(option);
        for (Option relevant : relativeOptions) {
            if (options.containsKey(relevant)) {
                return true;
            }
        }
        return false;
    }







}
