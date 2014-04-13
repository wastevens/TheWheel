package com.dstevens.comparators;

import java.util.Comparator;

public class Comparators {

    public static <E> Comparator<E> reverse(final Comparator<E> compator) {
        return new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return compator.compare(o2, o1);
            }
        };
    }
    
    public static <E extends Comparable<E>> Comparator<E> nullsLast(final Comparator<E> comparator) {
        return new Comparator<E>() {
            @Override
            public int compare(E e1, E e2) {
                if (e1 == e2) {
                    return 0;
                }
                if (e1 == null) {
                    return 1;
                }
                if (e2 == null) {
                    return -1;
                }
                return comparator.compare(e1, e2);
            }
        };
    }
    
    public static <E extends Comparable<E>> Comparator<E> nullsFirst(final Comparator<E> comparator) {
        return new Comparator<E>() {
            @Override
            public int compare(E e1, E e2) {
                if (e1 == e2) {
                    return 0;
                }
                if (e1 == null) {
                    return -1;
                }
                if (e2 == null) {
                    return 1;
                }
                return comparator.compare(e1, e2);
            }
        };
    }
}
