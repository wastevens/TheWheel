package com.dstevens.logging;


public enum LogLevel {

    FATAL,
    ERROR,
    WARN,
    DEBUG,
    INFO,
    TRACE;

    public boolean shouldLogAt(LogLevel level) {
        return this.ordinal() >= level.ordinal();
    }
    
}
