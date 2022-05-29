# loggers

![license](https://img.shields.io/github/license/IIpho3nix/loggers?style=for-the-badge)
![builds](https://img.shields.io/github/workflow/status/IIpho3nix/loggers/Auto%20Release?style=for-the-badge)
![commit](https://img.shields.io/github/last-commit/IIpho3nix/loggers?style=for-the-badge)
![size](https://img.shields.io/github/repo-size/IIpho3nix/loggers?style=for-the-badge)

a logging libary made in 30 minutes at 3am

# How To Use

## Logging

Call Loggerinitializer's init method with the folder you want the logs stored in passed as a java File class like this

```java
Loggerinitializer.init(new File("logs"));
```

then you can create a new instance of Logger from anywhere in your project like this

```java
Logger logger = new Logger("test");
```

then you can use the Built-In Logging methods on the newly declared varible like this

```java
logger.debug("this is a debug test var1: {} var2: {} ", "abc", 1234, "test");
logger.error("this is a error test var1: {} var2: {} ", "abc", 1234, "test");
logger.fatal("this is a fatal test var1: {} var2: {} ", "abc", 1234, "test");
logger.info("this is a info test var1: {} var2: {} ", "abc", 1234, "test");
logger.warn("this is a warn test var1: {} var2: {} ", "abc", 1234, "test");
logger.trace("this is a trace test var1: {} var2: {} ", "abc", 1234, "test");
```

whitch will print this output

```
[03:00:00] [TEST/DEBUG] this is a debug test var1: abc var2: 1234 test
[03:00:00] [TEST/ERROR] this is a error test var1: abc var2: 1234 test
[03:00:00] [TEST/FATAL] this is a fatal test var1: abc var2: 1234 test
[03:00:00] [TEST/INFO] this is a info test var1: abc var2: 1234 test
[03:00:00] [TEST/WARN] this is a warn test var1: abc var2: 1234 test
[03:00:00] [TEST/TRACE] this is a trace test var1: abc var2: 1234 test
```

if there is a '{}' in the logging string the next varible passed will   replace it and if there is none the next varible will be appended to the end of the log

## Crash Logging

Call Loggerinitializer's initcrashhandler method with the folder you want the crash-logs stored in passed as a java File class like this

```java
Loggerinitializer.initcrashhandler(new File("crash-logs"));
```

thats all you need to do

# Features

It Logs And Gzips Old Logs
It Crash-Logs And Gzips Old Crash-Logs
