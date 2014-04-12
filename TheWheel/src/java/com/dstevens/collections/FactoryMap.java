package com.dstevens.collections;

import static com.dstevens.collections.Maps.map;

import java.util.*;

import com.dstevens.collections.functions.Action;

public class FactoryMap<Key, Value> implements Map<Key, Value>{

    private final Action<Value> initialValueFactory;
    private Map<Key, Value> map;

    public FactoryMap(Action<Value> initialValueFactory) {
        this.map = map();
        this.initialValueFactory = initialValueFactory;
    }
    
    public static <Key, Value> FactoryMap<Key, Value> from(Collection<Key> keys, Action<Value> initialValueFactory) {
        FactoryMap<Key, Value> map = new FactoryMap<Key, Value>(initialValueFactory);
        for (Key key : keys) {
            map.put(key, initialValueFactory.act());
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
        Value initialValue = initialValueFactory.act();
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
        if (o instanceof FactoryMap) {
            @SuppressWarnings("rawtypes")
            FactoryMap that = (FactoryMap) o;
            return this.map.equals(that.map);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

}
