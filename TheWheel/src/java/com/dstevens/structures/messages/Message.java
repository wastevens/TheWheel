package com.dstevens.structures.messages;

import com.dstevens.utilities.ObjectExtensions;

public class Message {

    private final String key;
    private final Object[] objects;

    public Message(String key, Object... objects) {
        this.key = key;
        this.objects = objects;
    }

    public String getKey() {
        return key;
    }

    public Object[] getObjects() {
        return objects;
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
