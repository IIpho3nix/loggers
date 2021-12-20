# loggers

![license](https://img.shields.io/github/license/IIpho3nix/loggers)
![builds](https://img.shields.io/github/workflow/status/IIpho3nix/loggers/Auto%20Release)
![commit](https://img.shields.io/github/last-commit/IIpho3nix/loggers)
![size](https://img.shields.io/github/repo-size/IIpho3nix/loggers)

a logging libary made in 30 minutes at 3am


# How To Use

## Logging

Call Loggerinitializer's init method with the folder you want the logs stored in passed as a java File class like this

```java
Loggerinitializer.init(new File("logs"));
```

then you can create a new instance of Logger from anywhere in your project like this

```java
Logger logger = new Logger("NAME", false);
```

or like this if u want colors in the log

```java
Logger logger = new Logger("NAME", true);
```

then you can use info warn and error methods on the newly declared varible like this

```java
logger.info("this is a test");
logger.debug("this is a test");
logger.warn("this is a test");
logger.error("this is a test");
```

whitch will print this output

```
[3:0:0] [NAME/INFO] this is a test
[3:0:0] [NAME/DEBUG] this is a test
[3:0:0] [NAME/WARN] this is a test
[3:0:0] [NAME/ERROR] this is a test
```

## Crash Logging

Call Loggerinitializer's initcrashhandler method with the folder you want the crash-logs stored in passed as a java File class like this

```java
Loggerinitializer.initcrashhandler(new File("crash-logs"));
```

thats all you need to do

# Features

It Logs And Gzips Old Logs
It Crash-Logs And Gzips Old Crash-Logs
