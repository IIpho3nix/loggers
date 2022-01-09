package me.iipho3nix.loggers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class LoggerUtils {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss-mm-HH-dd-MM-YYYY");
    public static File logfile = null;
    public static File crashfile = null;
    public static boolean colorful = false;
    public static void writelog(String log, String filepath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filepath, true));
            pw.write(log + "\n");
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writetrace(Throwable e, String filepath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filepath, true));
            e.printStackTrace(pw);
            pw.close();
        }catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
