package com.dstevens.collections;

import java.util.*;

public class Sets {

    public static <E> Set<E> set() {
        return new HashSet<E>();
    }
    
    public static <E> Set<E> set(E element) {
        Set<E> set = set();
        set.add(element);
        return set;
    }
    
    public static <E> Set<E> set(E... elements) {
        return setFrom(Arrays.asList(elements));
    }
    
    public static <E> Set<E> setFrom(Collection<E> elements) {
        return new HashSet<E>(elements);
    }
    
    public static <E> Set<E> setWith(Collection<E> elements, E... elementsToAdd) {
        Set<E> setFrom = setFrom(elements);
        setFrom.addAll(set(elementsToAdd));
        return setFrom;
    }
    
    public static <E> Set<E> setWithout(Collection<E> elements, E... elementsToAdd) {
        Set<E> setFrom = setFrom(elements);
        setFrom.removeAll(set(elementsToAdd));
        return setFrom;
    }
}
