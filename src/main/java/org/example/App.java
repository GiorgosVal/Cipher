package org.example;

import logging.CustomLogger;
import logging.Level;
import logging.Logger;
import logging.LoggerFactory;
import options.OptionsLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        OptionsLoader optionsLoader = OptionsLoader.getOptionsLoader();
        optionsLoader.loadOptions(args);

        Logger logger = LoggerFactory.getLogger();
        logger.log(Level.DEBUG, "debug message");
        logger.log(Level.INFO, "info message");
        logger.log(Level.WARNING, "warning message");
        logger.log(Level.ERROR, "error message");

    }
}
