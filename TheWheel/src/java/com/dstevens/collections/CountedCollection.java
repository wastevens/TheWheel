package com.dstevens.collections;

import java.util.*;

import com.dstevens.collections.functions.Operation;

import static com.dstevens.collections.Lists.listFrom;

import static com.dstevens.collections.functions.Operations.transform;

import static com.dstevens.collections.Counted.counted;

public class CountedCollection<Value> extends BottomlessMap<Value, Integer> {

    private CountedCollection() {
        super(0);
    }
    
    public static <Value> CountedCollection<Value> count() {
        return new CountedCollection<Value>();
    }
    
    public static <Value> CountedCollection<Value> countOf(Collection<Value> values) {
        CountedCollection<Value> counted = new CountedCollection<Value>();
        for (Value value : values) {
            counted.increment(value);
        }
        return counted;
    }
    
    public Integer increment(Value value) {
        return addTo(value, 1);
    }
    
    public Integer decrement(Value value) {
        return addTo(value, -1);
    }
    
    public Integer addTo(Value value, Integer addend) {
        return put(value, (get(value) + addend));
    }
    
    public CountedCollection<Value> add(CountedCollection<Value> thoseValues) {
        CountedCollection<Value> counted = new CountedCollection<Value>();
        addEach(counted, this.entrySet());
        addEach(counted, thoseValues.entrySet());
        return counted;
    }

    private void addEach(CountedCollection<Value> counted, Set<Entry<Value, Integer>> thatEntrySet) {
        for (Entry<Value,Integer> entry : thatEntrySet) {
            counted.addTo(entry.getKey(), entry.getValue());
        }
    }
    
    public List<Counted<Value>> getAscendingOrdered() {
        return listFrom(transform(entrySet(), toKeys()));
    }
    
    public List<Counted<Value>> getDescendingOrdered() {
        List<Counted<Value>> orderedElements = getAscendingOrdered();
        Collections.reverse(orderedElements);
        return orderedElements;
    }

    private Operation<Entry<Value, Integer>, Counted<Value>> toKeys() {
        return new Operation<Entry<Value,Integer>, Counted<Value>>() {
            @Override
            public Counted<Value> apply(Entry<Value, Integer> input) {
                return counted(input.getKey(), input.getValue());
            }
        };
    }
}
