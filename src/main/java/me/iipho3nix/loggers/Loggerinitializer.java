package me.iipho3nix.loggers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.zip.GZIPOutputStream;

public class Loggerinitializer {
    public static void init(File logfolder) {
        if(!logfolder.exists()) {
            logfolder.mkdir();
        }
        File latestlog = new File(logfolder.getAbsolutePath() + "/latest.log");
        if(latestlog.exists()) {
            gziplog(latestlog.getAbsolutePath(), logfolder.getAbsolutePath() + "/" + LoggerUtils.dtf.format(LocalDateTime.now()) + ".log.gz");
            latestlog.delete();
        }
        LoggerUtils.logfile = latestlog;
    }

    public static void initcrashhandler(File crashfolder) {
        if(!crashfolder.exists()) {
            crashfolder.mkdir();
        }
        File latestcrash = new File(crashfolder.getAbsolutePath() + "/latest.crash");
        if(latestcrash.exists()) {
            gziplog(latestcrash.getAbsolutePath(), crashfolder.getAbsolutePath() + "/" + LoggerUtils.dtf.format(LocalDateTime.now()) + ".crash.gz");
            latestcrash.delete();
        }
        LoggerUtils.crashfile = latestcrash;
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }

    private static void gziplog(String file, String gzipFile) {
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(gzipFile);
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer)) != -1){
                gzipOS.write(buffer, 0, len);
            }
            gzipOS.close();
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
