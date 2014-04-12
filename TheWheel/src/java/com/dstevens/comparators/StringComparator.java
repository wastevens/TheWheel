package com.dstevens.comparators;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    public static final Comparator<String> INSTANCE = new StringComparator();
    
    private StringComparator() {
    }
    
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
    
    
}
