package options;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.StringUtils.*;

public class OptionTest {

    @Test
    public void getOption() {
    }

    @Test
    public void isAcceptingValue() {
    }

    @Test
    public void isBreakingOption() {
    }

    @Test
    public void createOption_for_lowecase_option() {
        assertNotNull(Option.createOption("-dbmode"));
    }

    @Test
    public void createOption_for_uppercase_option() {
        assertNotNull(Option.createOption("-DBMODE"));
    }

    @Test
    public void createOption_for_not_option_value() {
        assertNull(Option.createOption("notanoption"));
    }

    @Test
    public void createOption_for_empty_value() {
        assertNull(Option.createOption(EMPTY));
    }

    @Test
    public void createOption_for_null_value() {
        assertNull(Option.createOption(NULL));
    }


    @Test
    public void isOption_for_option_lowecase() {
        assertTrue(Option.isOption(VERBOSE));
    }

    @Test
    public void isOption_for_option_uppercase() {
        assertTrue(Option.isOption(VERBOSE.toUpperCase()));
    }

    @Test
    public void isOption_for_not_option() {
        assertFalse(Option.isOption("option"));
    }

    @Test
    public void isOption_for_empty_value() {
        assertFalse(Option.isOption(EMPTY));
    }

    @Test
    public void isOption_for_null_value() {
        assertFalse(Option.isOption(NULL));
    }

    @Test
    public void testGetRelativeOptions_for_one(){
        assertEquals(1, Option.getRelativeOptions(Option.ABOUT).size());
    }

    @Test
    public void testGetRelativeOptions_for_two(){
        assertEquals(2, Option.getRelativeOptions(Option.HELP).size());
    }

    @Test
    public void testGetRelativeOptions_for_null(){
        assertEquals(0, Option.getRelativeOptions(null).size());
    }
}