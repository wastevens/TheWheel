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
        if (!Objects.deepEquals(o1, o1)) {
            throw new AssertionError(MessageFormat.format("Equality is expected to be reflexive, but {0} is not equal to itself!", o1));
        }
        if (!Objects.deepEquals(o2, o2)) {
            throw new AssertionError(MessageFormat.format("Equality is expected to be reflexive, but {0} is not equal to itself!", o1));
        }
        if (!Objects.deepEquals(o1, o2)) {
            throw new AssertionError(MessageFormat.format("Expected {0} to be equal to {1}", o1, o2));
        }
        if (!Objects.deepEquals(o2, o1)) {
            throw new AssertionError(MessageFormat.format("Equality is expected to be symmetrics, but while {0} is equal to {1}, {1} is not equal to {0}", o1, o2));
        }
        if (o1.hashCode() != o2.hashCode()) {
            throw new AssertionError(MessageFormat.format("For any two equal objects, Java requires they produce equal hash code values; expected {0} but got {1} for {2} and {3}", o1.hashCode(), o2.hashCode(), o1, o2));
        }
        return this;
    }
    
    public EqualityTester assertNotEqualTo(Object o2) {
        if (Objects.deepEquals(o1, o2)) {
            throw new AssertionError(MessageFormat.format("Expected {0} to not be equal to {1}", o1, o2));
        }
        if (Objects.deepEquals(o2, o1)) {
            throw new AssertionError(MessageFormat.format("Equality is expected to be symmetrics, but while {0} is not equal to {1}, {1} is equal to {0}", o1, o2));
        }
        return this;
    }
    
}
