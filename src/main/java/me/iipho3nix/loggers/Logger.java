package me.iipho3nix.loggers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private String name;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Logger(String name) {
        this.name = name;
    }

    public void info(String log) {
        if(LoggerUtils.logfile == null) return;
        log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/INFO" + "] " + log;
        System.out.println(LoggerUtils.colorful ? "\u001B[32m" + log + "\u001B[0m" : log);
        LoggerUtils.writelog(log, LoggerUtils.logfile.getAbsolutePath());
    }

    public void debug(String log) {
        if(LoggerUtils.logfile == null) return;
        log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/DEBUG" + "] " + log;
        System.out.println(LoggerUtils.colorful ? "\u001B[37m" + log + "\u001B[0m" : log);
        LoggerUtils.writelog(log, LoggerUtils.logfile.getAbsolutePath());
    }

    public void warn(String log) {
        if(LoggerUtils.logfile == null) return;
        log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/WARN" + "] " + log;
        System.out.println(LoggerUtils.colorful ? "\u001B[33m" + log + "\u001B[0m" : log);
        LoggerUtils.writelog(log, LoggerUtils.logfile.getAbsolutePath());
    }

    public void error(String log) {
        if(LoggerUtils.logfile == null) return;
        log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/ERROR" + "] " + log;
        System.out.println(LoggerUtils.colorful ? "\u001B[31m" + log + "\u001B[0m" : log);
        LoggerUtils.writelog(log, LoggerUtils.logfile.getAbsolutePath());
    }
}
