package com.dstevens.collections;

import java.util.*;

public class Lists {

    public static <E> List<E> list() {
        return new ArrayList<E>();
    }
    
    public static <E> List<E> list(E element) {
        List<E> list = list();
        list.add(element);
        return list;
    }
    
    public static <E> List<E> list(@SuppressWarnings("unchecked") E... elements) {
        return listFrom(Arrays.asList(elements));
    }
    
    public static <E> List<E> listFrom(Collection<E> elements) {
        return new ArrayList<E>(elements);
    }
    
    public static <E> List<E> listWith(Collection<E> elements, @SuppressWarnings("unchecked") E... elementsToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.addAll(list(elementsToAdd));
        return listFrom;
    }
    
    public static <E> List<E> listWithout(Collection<E> elements, @SuppressWarnings("unchecked") E... elementsToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.removeAll(list(elementsToAdd));
        return listFrom;
    }
    
    public static <E extends Comparable<E>> List<E> sort(Collection<E> elements) {
        List<E> sortedList = listFrom(elements);
        Collections.sort(sortedList);
        return sortedList;
    }
}
