package options;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public enum Option {

    ALG(StringUtils.ALG, true, false, StringUtils.ALG_SEMANTIC),
    MODE(StringUtils.MODE, true, false, StringUtils.MODE_SEMANTIC),
    KEY(StringUtils.KEY, true, false, StringUtils.KEY_SEMANTIC),

    DBIN(StringUtils.DBIN, false, false, StringUtils.DBIN_SEMANTIC),
    IN(StringUtils.IN, true, false, StringUtils.IN_SEMANTIC),
    INPUT(StringUtils.INPUT, true, false, StringUtils.INPUT_SEMANTIC),
    DATA(StringUtils.DATA, true, false, StringUtils.DATA_SEMANTIC),

    DBOUT(StringUtils.DBOUT, true, false, StringUtils.DBOUT_SEMANTIC),
    OUT(StringUtils.OUT, true, false, StringUtils.OUT_SEMANTIC),
    OUTPUT(StringUtils.OUTPUT, true, false, StringUtils.OUTPUT_SEMANTIC),

    DBMODE(StringUtils.DBMODE, false, false, StringUtils.DBMODE_SEMANTIC),
    DBCONF(StringUtils.DBCONF, true, false, StringUtils.DBCONF_SEMANTIC),
    CONFIG(StringUtils.CONFIG, true, false, StringUtils.CONFIG_SEMANTIC),

    H(StringUtils.H, false, true, StringUtils.H_SEMANTIC),
    HELP(StringUtils.HELP, false, true, StringUtils.HELP_SEMANTIC),
    VERSION(StringUtils.VERSION, false, true, StringUtils.VERSION_SEMANTIC),
    ABOUT(StringUtils.ABOUT, false, false, StringUtils.ABOUT_SEMANTIC),

    V(StringUtils.V, false, false, StringUtils.V_SEMANTIC),
    VERBOSE(StringUtils.VERBOSE, false, false, StringUtils.VERBOSE_SEMANTIC);




    private String option;
    private boolean isAcceptingValue;
    private boolean isBreakingOption;
    private String semantic;

    Option(String option, boolean isAcceptingValue, boolean isBreakingOption, String semantic) {
        this.option = option;
        this.isAcceptingValue = isAcceptingValue;
        this.isBreakingOption = isBreakingOption;
        this.semantic = semantic;
    }

    public String getOption(){
        return this.option;
    }

    public boolean isAcceptingValue(){
        return this.isAcceptingValue;
    }

    public boolean isBreakingOption(){
        return this.isBreakingOption;
    }

    public String getSemantic() {
        return this.semantic;
    }

    public static Option createOption(String value) {
        Option option = null;
        if (isOption(value)) {
            option = Option.valueOf(value.toUpperCase().replace("-", ""));
        }
        return option;
    }

    public static boolean isOption(String value) {
        for (Option option : Option.values()) {
            if (option.getOption().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static List<Option> getRelativeOptions(Option option) {
        List<Option> relativeOptions = new ArrayList<>();
        if (Objects.isNull(option)) {
            return relativeOptions;
        }
        for(Option o : Option.values()) {
            if (o.semantic.equals(option.semantic)) {
                relativeOptions.add(o);
            }
        }
        return relativeOptions;
    }
}
