package me.iipho3nix.loggers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    public void uncaughtException(Thread t, Throwable e) {
        if(LoggerUtils.crashfile == null) return;
        LoggerUtils.writelog("Crash Logged At " + dtf.format(LocalDateTime.now()) + " in " + dtf2.format(LocalDateTime.now()) + "\n", LoggerUtils.crashfile.getAbsolutePath());
        LoggerUtils.writetrace(e, LoggerUtils.crashfile.getAbsolutePath());
        e.printStackTrace();
    }
}
