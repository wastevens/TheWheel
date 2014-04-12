package com.dstevens.testing;

import java.text.MessageFormat;
import java.util.Objects;

public class EqualityTester {

    private Object o1;

    private EqualityTester(Object o1) {
        this.o1 = o1;
    }

    public static EqualityTester testing(Object o) {
        return new EqualityTester(o);
    }
    
    public EqualityTester assertEqualTo(Object o2) {
        if (Objects.deepEquals(o1, o2) && Objects.deepEquals(o2, o1) &&
            Objects.hash(o1) == Objects.hash(o2)) {
            return this;
        }
        throw new AssertionError(MessageFormat.format("Expected {0} to be equal to {1}", o1, o2));
    }
    
    public EqualityTester assertNotEqualTo(Object o2) {
        if (!Objects.deepEquals(o1, o2) && !Objects.deepEquals(o2, o1)) {
            return this;
        }
        throw new AssertionError(MessageFormat.format("Expected {0} to not be equal to {1}", o1, o2));
    }
    
}
