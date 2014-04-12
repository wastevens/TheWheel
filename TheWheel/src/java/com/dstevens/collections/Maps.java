package com.dstevens.collections;

import java.util.*;

import com.dstevens.structures.Pair;
import com.dstevens.utilities.ObjectExtensions;

public class Maps {

    public static <Key, Value> Map<Key, Value> map() {
        return new HashMap<Key, Value>();
    }
    
    public static <Key, Value> Map<Key, Value> map(Pair<Key, Value>... keyValuePair) {
        HashMap<Key, Value> map = new HashMap<Key, Value>();
        for (Pair<Key,Value> pair : keyValuePair) {
            map.put(pair.key, pair.value);
        }
        return map;
    }
    
    public static <Key, Value> FluentMap<Key, Value> mapWith(Key key, Value value) {
        FluentMap<Key, Value> fluentMap = new FluentMap<Key, Value>(Maps.<Key, Value>map());
        fluentMap.put(key, value);
        return fluentMap;
    }
    
    public static class FluentMap<K, V> implements Map<K, V> {
        
        private Map<K, V> delegate;
        
        private FluentMap(Map<K, V> delegate) {
            this.delegate = delegate;
        }

        public FluentMap<K, V> andWith(K key, V value) {
            FluentMap<K, V> newMap = new FluentMap<K, V>(delegate);
            newMap.put(key, value);
            return newMap;
        }
        
        @Override
        public void clear() {
            delegate.clear();
        }

        @Override
        public boolean containsKey(Object key) {
            return delegate.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return delegate.containsValue(value);
        }

        @Override
        public Set<java.util.Map.Entry<K, V>> entrySet() {
            return delegate.entrySet();
        }

        @Override
        public V get(Object key) {
            return delegate.get(key);
        }

        @Override
        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        @Override
        public Set<K> keySet() {
            return delegate.keySet();
        }

        @Override
        public V put(K key, V value) {
            return delegate.put(key, value);
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            delegate.putAll(m);
        }

        @Override
        public V remove(Object key) {
            return delegate.remove(key);
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public Collection<V> values() {
            return delegate.values();
        }
        
        @Override
        public String toString() {
            return ObjectExtensions.toStringFor(this);
        }
        
        @Override
        public boolean equals(Object that) {
            return ObjectExtensions.equals(this, that);
        }
        
        @Override
        public int hashCode() {
            return ObjectExtensions.hashCodeFor(this);
        }
    }
    
}
