package com.dstevens.structures.optional;

import com.dstevens.utilities.ObjectExtensions;

public class WithValue<Value> extends Optional<Value> {

    private final Value value;

    WithValue(Value value) {
        this.value = value;
    }
    
    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public Value value() {
        return value;
    }
    
    
    @Override
    public boolean equals(Object that) {
        return ObjectExtensions.equals(this, that);
    }
    
    @Override
    public int hashCode() {
        return ObjectExtensions.hashCodeFor(this);
    }
    
    @Override
    public String toString() {
        return ObjectExtensions.toStringFor(this);
    }

}
