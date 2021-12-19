# loggers
a logging libary made in 30 minutes at 3am


# How To Use

Call Loggerinitializer's init method with the folder you want the logs stored in passed as a java File class like this

```java
Loggerinitializer.init(new File("logs"));
```

then you can create a new instance of Logger from anywhere in your project like this

```java
Logger logger = new Logger("NAME");
```

then you can use info warn and error methods on the newly declared varible like this

```java
logger.info("this is a test");
logger.warn("this is a test");
logger.error("this is a test");
```

whitch will print this output

```
[3:0:0] [NAME/INFO] this is a test
[3:0:0] [NAME/WARN] this is a test
[3:0:0] [NAME/ERROR] this is a test
```

# Features

It Logs And Gzips Old Logs
