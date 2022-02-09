package me.iipho3nix.loggers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Logger {
    private String name;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Logger(String name) {
        this.name = name.toUpperCase();
    }

    public void debug(Object... logs) {
        log("DEBUG", logs);
    }

    public void error(Object... logs) {
        log("ERROR", logs);
    }

    public void fatal(Object... logs) {
        log("FATAL", logs);
    }

    public void info(Object... logs) {
        log("INFO", logs);
    }

    public void warn(Object... logs) {
        log("WARN", logs);
    }

    public void trace(Object... logs) {
        log("TRACE", logs);
    }

    public void log(String level, Object... logs) {
        if(LoggerUtils.logfile == null) return;
        if(!LoggerUtils.logfile.exists()) {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LoggerUtils.logfile.createNewFile();
                LoggerUtils.writelog("Logging Started At " + dtf.format(LocalDateTime.now()) + " In " + dtf2.format(LocalDateTime.now()) + "\n", LoggerUtils.logfile.getAbsolutePath());
            }catch (IOException e) {
                return;
            }
        }
        String log = "";
        for(Object o : logs) {
            if(log.contains("{}")) {
                log = log.replaceFirst(Pattern.quote("{}"), String.valueOf(o));
            }else{
                log = log + String.valueOf(o);
            }
        }
        log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/" + level.toUpperCase() + "] " + log;
        System.out.println(log);
        LoggerUtils.writelog(log, LoggerUtils.logfile.getAbsolutePath());
    }
}
