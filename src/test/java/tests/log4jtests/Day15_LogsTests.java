package tests.log4jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_LogsTests {

    private static Logger logger = LogManager.getLogger(Day15_LogsTests.class.getName());

    @Test
    public void test1(){
        logger.fatal("Fatal logger !!!");
        logger.error("Error logger !!!");
        logger.warn("Warn logger !!!");
        logger.debug("Debug logger !!!");
        logger.info("Info logger !!!");


    }
}
