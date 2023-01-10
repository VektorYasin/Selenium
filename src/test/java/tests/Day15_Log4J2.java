package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {

    //Create Object
    private static Logger logger= LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void log44jTest(){
      //use logger object to log/print information
      logger.fatal("Fatal log!!!");// prints by default
      logger.error("Error log!!!");// prints by default
      logger.warn("Warn log!!!");
      logger.debug("Debug log!!!");
      logger.info("Info log!!!");

    }
}
