package me.iipho3nix.loggers;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Loggerinitializer.init(new File("logs"));
        Loggerinitializer.initcrashhandler(new File("crash-logs"));
        Logger logger = new Logger("NAME", true);
        logger.debug("test");
        logger.info("test");
        logger.warn("test");
        logger.error("test");
        System.out.println(10 / 0);
    }
}
