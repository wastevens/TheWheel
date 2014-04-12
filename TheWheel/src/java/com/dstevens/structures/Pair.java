package com.dstevens.structures;

import java.util.*;

import static com.dstevens.collections.Lists.list;


public class Pair<Key, Value> {

    public final Key key;
    public final Value value;

    protected Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public static <Key, Value> Pair<Key, Value> pair(Key key, Value value) {
        return new Pair<Key, Value>(key, value);
    }
    
    public static <Key, Value> Collection<Pair<Key, Value>> zip(List<Key> keys, List<Value> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Size of collections must be the same to zip them together!  Cannot zip " + keys + " and " + values +"!");
        }
        List<Pair<Key, Value>> pairs = list();
        for(int i=0;i<keys.size();i++) {
            pairs.add(pair(keys.get(i), values.get(i)));
        }
        return pairs;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            @SuppressWarnings("rawtypes")
            Pair that = (Pair) o;
            return (this.key.equals(that.key) && this.value.equals(that.value));
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return key.hashCode() + value.hashCode();
    }
    
    public String toString() {
        return "[" + key + ", " + value + "]";
    }
}
