package com.dstevens.structures.optional;

public abstract class Optional<Value> {

    public abstract boolean hasValue();
    public abstract Value value();
    
    public static <Value> Optional<Value> withValue(Value value) {
        return new WithValue<Value>(value);
    }
    
    public static <Value> Optional<Value> withoutValue() {
        return new WithoutValue<Value>();
    }
    
    public static <Value> Optional<Value> withOptional(Value value) {
        return (value == null) ? new WithoutValue<Value>() : new WithValue<Value>(value);
    }
}
