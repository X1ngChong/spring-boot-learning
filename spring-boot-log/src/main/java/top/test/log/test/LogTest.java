package top.test.log.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JXS
 */
@Slf4j
public class LogTest {
    //sl4j 是日志的门面
//    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
//        LOGGER.trace("Trace 日志 ****");
//        LOGGER.debug("debug 日志 ****");
//        LOGGER.info("info 日志 ****");
//        LOGGER.warn("warn 日志 ****");
//        LOGGER.error("error 日志 ****");
           // log.info("hello world");
        Logger myLogger = LoggerFactory.getLogger("myLogger");
        myLogger.info("hello world");

    }
}
