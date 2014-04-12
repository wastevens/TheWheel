package com.dstevens.comparators;

import java.util.Comparator;

public class LongComparator implements Comparator<Long> {

    public static final Comparator<Long> INSTANCE = new LongComparator();
    
    private LongComparator() {
    }
    
    @Override
    public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
    }
    
    
}
