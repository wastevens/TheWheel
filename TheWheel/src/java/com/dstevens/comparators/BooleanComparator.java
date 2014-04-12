package com.dstevens.comparators;

import java.util.Comparator;

public class BooleanComparator implements Comparator<Boolean> {

    public static final Comparator<Boolean> INSTANCE = new BooleanComparator();
    
    private BooleanComparator() {
    }
    
    @Override
    public int compare(Boolean o1, Boolean o2) {
        return o1.compareTo(o2);
    }
    
    
}
