package me.iipho3nix.loggers;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private String name;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Logger(String name) {
        this.name = name;
    }

    public void info(String log) {
        if(Loggerinitializer.logfile != null) {
            log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/INFO" + "] " + log;
            System.out.println(log);
            write(log);
        }
    }

    public void warn(String log) {
        if(Loggerinitializer.logfile != null) {
            log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/WARN" + "] " + log;
            System.out.println(log);
            write(log);
        }
    }

    public void error(String log) {
        if(Loggerinitializer.logfile != null) {
            log = "[" + dtf.format(LocalDateTime.now()) + "] [" + name + "/ERROR" + "] " + log;
            System.out.println(log);
            write(log);
        }
    }

    private void write(String log) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(Loggerinitializer.logfile.getAbsolutePath(), true));
            pw.write(log + "\n");
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
