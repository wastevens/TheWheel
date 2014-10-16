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
    
    public static <E> Set<E> set(@SuppressWarnings("unchecked") E... elements) {
        return setFrom(Arrays.asList(elements));
    }
    
    public static <E> Set<E> setFrom(Iterable<E> elements) {
        Set<E> set = set();
        for (E e : elements) {
            set.add(e);
        }
        return set;
    }
    
    public static <E> Set<E> setWith(Collection<E> elements, @SuppressWarnings("unchecked") E... elementsToAdd) {
        Set<E> setFrom = setFrom(elements);
        setFrom.addAll(set(elementsToAdd));
        return setFrom;
    }
    
    public static <E> Set<E> setWithout(Collection<E> elements, @SuppressWarnings("unchecked") E... elementsToRemove) {
        Set<E> setFrom = setFrom(elements);
        setFrom.removeAll(set(elementsToRemove));
        return setFrom;
    }
}
