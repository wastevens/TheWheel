package com.dstevens.structures.optional;

import com.dstevens.utilities.ObjectExtensions;

public class WithoutValue<Value> extends Optional<Value> {

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public Value value() {
        throw new IllegalStateException("No value exists for this optional to retrieve!");
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
