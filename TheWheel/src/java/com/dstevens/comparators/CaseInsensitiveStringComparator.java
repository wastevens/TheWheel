package com.dstevens.comparators;

import java.util.Comparator;

public class CaseInsensitiveStringComparator implements Comparator<String> {

    public static final Comparator<String> INSTANCE = new CaseInsensitiveStringComparator();
    
    private CaseInsensitiveStringComparator() {
    }
    
    @Override
    public int compare(String o1, String o2) {
        return o1.toUpperCase().compareTo(o2.toUpperCase());
    }
    
    
}
