package Lesson_6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class LoggerApp {
    private static final Logger LOGGER = LogManager.getLogger(LoggerApp.class);

    public static void main(String[] args) {
        LOGGER.fatal("Fatal");
        LOGGER.error("Error");
        LOGGER.warn("Warn");
        LOGGER.info("Info");
        LOGGER.debug("Debug");
        LOGGER.trace("Trace");
    }

    public static List<String> maxK(){
        List<String> list = new LinkedList<>();
        int max = 7;

        for (int i = 1; i < 21; i++) {
            list.add(String.valueOf(i));
            if (list.size() > max) {
                list.remove(0);
            }
            LOGGER.debug("List is {} for i {}",list,i);
        }
        return list;
    }
}
