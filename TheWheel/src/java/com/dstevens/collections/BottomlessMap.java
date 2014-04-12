package com.dstevens.collections;

import java.util.*;

import static com.dstevens.collections.Maps.map;

public class BottomlessMap<Key, Value> implements Map<Key, Value>{

    private final Value initialValue;
    private Map<Key, Value> map;

    public BottomlessMap(Value initialValue) {
        this.map = map();
        this.initialValue = initialValue;
    }
    
    public static <Key, Value> BottomlessMap<Key, Value> from(Collection<Key> keys, Value initialValue) {
        BottomlessMap<Key, Value> map = new BottomlessMap<Key, Value>(initialValue);
        for (Key key : keys) {
            map.put(key, initialValue);
        }
        return map;
    }
    
    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {
        return map.entrySet();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Value get(Object key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        map.put((Key) key, initialValue);
        return initialValue;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Set<Key> keySet() {
        return map.keySet();
    }

    @Override
    public Value put(Key key, Value value) {
        return map.put(key, value);
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> thatMap) {
        map.putAll(thatMap);
    }

    @Override
    public Value remove(Object key) {
        return map.remove(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Collection<Value> values() {
        return map.values();
    }
    
    @Override
    public String toString() {
        return map.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof BottomlessMap) {
            @SuppressWarnings("rawtypes")
            BottomlessMap that = (BottomlessMap) o;
            return this.map.equals(that.map);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

}
