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
    
    public static <E> List<E> listFrom(Iterable<E> elements) {
        List<E> list = list();
        for (E e : elements) {
            list.add(e);
        }
        return list;
    }
    
    public static <E> List<E> listWith(Collection<E> elements, E elementToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.add(elementToAdd);
        return listFrom;
    }
    
    public static <E> List<E> listWithout(Collection<E> elements, E elementToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.remove(elementToAdd);
        return listFrom;
    }
    
    public static <E extends Comparable<E>> List<E> sort(Collection<E> elements) {
        List<E> sortedList = listFrom(elements);
        sortedList.sort(Comparator.naturalOrder());
        return sortedList;
    }
}
