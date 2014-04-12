package com.dstevens.comparators;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    public static final Comparator<Integer> INSTANCE = new IntegerComparator();
    
    private IntegerComparator() {
    }
    
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
    
    
}
