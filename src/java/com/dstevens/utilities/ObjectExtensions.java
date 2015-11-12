package com.dstevens.utilities;

import org.apache.commons.lang3.builder.*;

public final class ObjectExtensions {

    public static final boolean equals(Object o1, Object o2) {
        return EqualsBuilder.reflectionEquals(o1, o2, false);
    }
    
    public static int hashCodeFor(Object o) {
       return HashCodeBuilder.reflectionHashCode(o, false);
    }
    
    public static String toStringFor(Object o) {
        return ReflectionToStringBuilder.toString(o, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
