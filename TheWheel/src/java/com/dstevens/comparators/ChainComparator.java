package com.dstevens.comparators;

import static com.dstevens.collections.Lists.list;

import java.util.*;

public class ChainComparator<E> implements Comparator<E> {

    private final List<Comparator<E>> comparators;

    private ChainComparator(Comparator<E> comparator) {
        this.comparators = list(comparator);
    }

    private ChainComparator(List<Comparator<E>> comparators) {
        this.comparators = comparators;
    }
    
    private ChainComparator(List<Comparator<E>> comparators, Comparator<E> comparator) {
        this.comparators = comparators;
        this.comparators.add(comparator);
    }
    
    public static <E> ChainComparator<E> compare(Comparator<E> comparator) {
        return new ChainComparator<E>(comparator);
    }

    public static <E> ChainComparator<E> by(Comparator<E> comparator) {
        return new ChainComparator<E>(comparator);
    }
    
    public static <E> ChainComparator<E> by(List<Comparator<E>> comparators) {
        return new ChainComparator<E>(comparators);
    }
    
    public ChainComparator<E> then(Comparator<E> comparator) {
        return new ChainComparator<E>(comparators, comparator);
    }

    @Override
    public int compare(E o1, E o2) {
        for (Comparator<E> comparator : comparators) {
            int value = comparator.compare(o1, o2);
            if (value != 0) return value;
        }
        return 0;
    }
    
}
