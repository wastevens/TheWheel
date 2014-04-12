package com.dstevens.logging;

import java.util.*;

public class SystemOutLogger {
    
    private static LogLevel logLevel = LogLevel.ERROR;
    
    @SuppressWarnings("rawtypes")
    private static Map<Class, LogLevel> specificClassLogging = new HashMap<Class, LogLevel>();
    
    @SuppressWarnings("rawtypes")
    public static SystemOutLogger logFor(Class klazz) {
        return new SystemOutLogger(klazz);
    }

    @SuppressWarnings("rawtypes")
    private Class klazz;
    
    @SuppressWarnings("rawtypes")
    private SystemOutLogger(Class klazz) {
        this.klazz = klazz;
    }
    
    public static void logAt(LogLevel level) {
        logLevel = level;
    }
    
    @SuppressWarnings("rawtypes")
    public static void logAt(LogLevel level, Class klazz) {
        specificClassLogging.put(klazz, level);
    }
    
    public void fatal(String msg, Exception... exceptions) {
        logAt(LogLevel.FATAL, msg, exceptions);
    }
    
    public void error(String msg, Exception... exceptions) {
        logAt(LogLevel.ERROR, msg, exceptions);
    }
    
    public void warn(String msg, Exception... exceptions) {
        logAt(LogLevel.WARN, msg, exceptions);
    }
    
    public void debug(String msg, Exception... exceptions) {
        logAt(LogLevel.DEBUG, msg, exceptions);
    }
    
    public void info(String msg, Exception... exceptions) {
        logAt(LogLevel.INFO, msg, exceptions);
    }
    
    public void trace(String msg, Exception... exceptions) {
        logAt(LogLevel.TRACE, msg, exceptions);
    }

    public void fatalIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.FATAL, msg, exceptions);
    }
    
    public void errorIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.ERROR, msg, exceptions);
    }
    
    public void warnIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.WARN, msg, exceptions);
    }
    
    public void debugIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.DEBUG, msg, exceptions);
    }
    
    public void infoIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.INFO, msg, exceptions);
    }
    
    public void traceIf(boolean shouldLog, String msg, Exception... exceptions) {
        if (shouldLog) logAt(LogLevel.TRACE, msg, exceptions);
    }
    
    private void logAt(LogLevel minimumLogLevel, String msg, Exception... exceptions) {
        if (shouldLog(klazz, minimumLogLevel)) {
            System.out.println("[" + klazz.getSimpleName() +"]["+minimumLogLevel.name()+"] " + msg);
            for (Exception exception : exceptions) {
                System.out.println(exception);
                exception.printStackTrace(System.out);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private boolean shouldLog(Class klazz, LogLevel minimumLogLevel) {
        return (specificClassLogging.containsKey(klazz) && specificClassLogging.get(klazz).shouldLogAt(minimumLogLevel)) || logLevel.shouldLogAt(minimumLogLevel);
    }
}
