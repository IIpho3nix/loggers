package me.iipho3nix.loggers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.GZIPOutputStream;

public class Loggerinitializer {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY-HH-mm-ss");
    public static File logfile = null;
    public static void init(File logfolder) {
        if(!logfolder.exists()) {
            logfolder.mkdir();
        }
        File latestlog = new File(logfolder.getAbsolutePath() + "/latest.log");
        if(latestlog.exists()) {
            gziplog(latestlog.getAbsolutePath(), logfolder.getAbsolutePath() + "/" + dtf.format(LocalDateTime.now()) + ".log.gz");
            latestlog.delete();
        }
        try {
            latestlog.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logfile = latestlog;
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
