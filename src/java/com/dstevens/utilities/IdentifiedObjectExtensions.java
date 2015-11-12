package com.dstevens.utilities;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class IdentifiedObjectExtensions {

    public static final <E> boolean equals(Identified<E> o1, Object o2) {
        if(o1 == null || o2 == null) {
            return false;
        }
        return (sameClass(o1, o2) && sameClass(o1.getId(), idOf(o2))) && o1.getId().equals(idOf(o2));
    }

    private static boolean sameClass(Object o1, Object o2) {
        return o1.getClass().isAssignableFrom(o2.getClass()) &&
               o2.getClass().isAssignableFrom(o1.getClass());
    }
    
    private static Object idOf(Object o) {
        return Identified.class.cast(o).getId();
    }
    
    public static final <E, T extends Identified<E>> int hashCodeFor(T o) {
       return o.getId().hashCode();
    }
    
    public static final String toStringFor(Object o) {
        return ReflectionToStringBuilder.toString(o, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
