package options;

import org.junit.Test;
import utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

public class OptionsLoaderTest {
    OptionsLoader optionsLoader = new OptionsLoader();

    @Test
    public void testLoadOptions_for_an_option_with_no_value() {
        String[] args = {"-v"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_an_option_with_value() {
        String[] args = {"-alg", "encryption"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_an_option_with_empty_value() {
        String[] args = {"-alg", StringUtils.EMPTY};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_an_option_with_null_value() {
        String[] args = {"-alg", StringUtils.NULL};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_two_options_with_no_values_while_the_first_accepting_value() {
        String[] args = {"-alg", "-verbose"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_two_options_with_no_values_while_the_second_accepts_value() {
        String[] args = {"-verbose", "-alg"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_three_options_with_values_while_the_second_accepts_value() {
        String[] args = {"-verbose", "-alg", "encryption"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_three_options_with_values_while_the_third_accepts_value() {
        String[] args = {"-verbose", "encryption", "-alg"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_three_options_with_no_values_while_the_third_accepts_value() {
        String[] args = {"encryption", "-verbose", "-alg"};

        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_three_options_with_no_values_while_the_third_accepts_value2() {
        String[] args = {"-v", "-v", "-alg"};
        optionsLoader.loadOptions(args);
    }

    @Test
    public void testLoadOptions_for_relevantOptions() {
        String[] args = {"-v", "-v", "-verbose", "-V", "-VERBOSE"};
        optionsLoader.loadOptions(args);
    }

    @Test
    public void testIsRelativeOptionPresent_case_true() {
        Map<Option, String> options = new HashMap<>();
        Option h = Option.H;
        Option help = Option.HELP;
        options.put(h, null);
        assertTrue(optionsLoader.isRelativeOptionPresent(help, options));
        assertTrue(optionsLoader.isRelativeOptionPresent(h, options));
    }

    @Test
    public void testIsRelativeOptionPresent_case_false() {
        Map<Option, String> options = new HashMap<>();
        Option h = Option.H;
        Option about = Option.ABOUT;
        options.put(h, null);
        assertFalse(optionsLoader.isRelativeOptionPresent(about, options));
    }

    @Test
    public void testIsRelativeOptionPresent_case_null() {
        Map<Option, String> options = new HashMap<>();
        Option h = Option.H;
        options.put(h, null);
        assertFalse(optionsLoader.isRelativeOptionPresent(null, options));
    }

    @Test
    public void testLoadOptions_realCase_scenario(){
        String[] args = {"not valid", "-v", "", "-help", "-h", "-ABOUT", "-version", "notvalid", "-notValid", "-config", "value of config",
                " ", null, "-ALG", "shift", "-alg", "unicode", "-mODE", "enc", "-MODE", "decryption", "-KEY", null,
                "-DBMODE", "off", "-DBIN", "-DBOUT", "-in", "value_of_input", "-INPUT", "-VERBOSE", "-data", "-OUTPUT", "output_value",
                "-out", "new output value", "-dbconf", null, "c"

        };
        optionsLoader.loadOptions(args);
        Map<Option, String> options = optionsLoader.getOptions();

        assertFalse(options.containsKey(StringUtils.EMPTY));
        assertFalse(options.containsKey(StringUtils.NULL));
        assertFalse(options.containsKey(" "));
        assertFalse(options.containsKey("not valid"));
        assertFalse(options.containsKey("notvalid"));
        assertFalse(options.containsKey("-notValid"));
        assertFalse(options.containsKey("value of config"));
        assertFalse(options.containsKey("off"));
        assertFalse(options.containsKey("value_of_input"));
        assertFalse(options.containsKey("output_value"));
        assertFalse(options.containsKey("new output value"));
        assertFalse(options.containsKey("c"));
        assertFalse(options.containsKey(Option.VERBOSE));
        assertFalse(options.containsKey(Option.H));
        assertFalse(options.containsKey(Option.INPUT));
        assertFalse(options.containsKey(Option.OUT));

        assertTrue(options.containsKey(Option.V));
        assertNull(options.get(Option.V));
        assertTrue(options.containsKey(Option.HELP));
        assertNull(options.get(Option.HELP));
        assertTrue(options.containsKey(Option.ABOUT));
        assertNull(options.get(Option.ABOUT));
        assertTrue(options.containsKey(Option.VERSION));
        assertNull(options.get(Option.VERSION));
        assertTrue(options.containsKey(Option.CONFIG));
        assertEquals("value of config", options.get(Option.CONFIG));
        assertTrue(options.containsKey(Option.ALG));
        assertEquals("shift", options.get(Option.ALG));
        assertTrue(options.containsKey(Option.MODE));
        assertEquals("enc", options.get(Option.MODE));
        assertTrue(options.containsKey(Option.KEY));
        assertNull(options.get(Option.KEY));
        assertTrue(options.containsKey(Option.DBMODE));
        assertNull(options.get(Option.DBMODE));
        assertTrue(options.containsKey(Option.DBIN));
        assertNull(options.get(Option.DBIN));
        assertTrue(options.containsKey(Option.DBOUT));
        assertNull(options.get(Option.DBOUT));
        assertTrue(options.containsKey(Option.IN));
        assertEquals("value_of_input", options.get(Option.IN));
        assertTrue(options.containsKey(Option.DATA));
        assertNull(options.get(Option.DATA));
        assertTrue(options.containsKey(Option.OUTPUT));
        assertEquals("output_value", options.get(Option.OUTPUT));
        assertTrue(options.containsKey(Option.DBCONF));
        assertNull(options.get(Option.DBCONF));



    }



}