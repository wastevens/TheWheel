package com.dstevens.testing;

import static com.dstevens.collections.Lists.list;

import java.util.List;

import org.apache.commons.lang3.builder.*;

public class Assertions {

    public static void assertListsEqual(List<?> expected, List<?> actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected == null) {
            throw new AssertionError("Expected null, but was " + actual);
        }
        if (actual == null) {
            throw new AssertionError("Expected non-null, but was null");
        }
        if (expected.size() != actual.size()) {
            throw new AssertionError("Expected and actual sizes differ; expected " + expected.size() + " elements, but but was " + actual.size() + " elements.  Expected " + expected + ", but was: " + actual);
        }
        List<String> errorMessages = list();
        for (int i=0;i<expected.size();i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                errorMessages.add("[" + i +"]: expected " + expected.get(i) + ", but was " + actual.get(i));
            }
        }
        if (!errorMessages.isEmpty()) {
            throw new AssertionError("Expected and actual differ: " + errorMessages + "; Expected " + expected + ", but was: " + actual);
        }
    }
    
    public static void assertEqualValues(Object expected, Object actual) {
        if (!EqualsBuilder.reflectionEquals(expected, actual, true)) {
            throw new AssertionError("Expected " + stringFor(expected) + " but was " + stringFor(actual));
        }
    }
    
    private static String stringFor(Object o) {
        return ReflectionToStringBuilder.toString(o, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
