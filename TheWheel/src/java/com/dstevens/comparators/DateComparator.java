package com.dstevens.comparators;

import java.util.*;

public class DateComparator implements Comparator<Date> {

    public static final Comparator<Date> INSTANCE = new DateComparator();
    
    private DateComparator() {
    }
    
    @Override
    public int compare(Date o1, Date o2) {
        return o1.compareTo(o2);
    }
    
    
}
