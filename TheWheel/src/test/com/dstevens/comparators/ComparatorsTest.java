package com.dstevens.comparators;

import static com.dstevens.collections.Lists.list;
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class ComparatorsTest {

    @Test
    public void testComplexChainComparator() {
        List<String> foo = list("c", null, "b", "d", "a", "e", null, "f");
        Collections.sort(foo, Comparators.nullsLast(StringComparator.INSTANCE));
        assertEquals(list("a", "b", "c", "d", "e", "f", null, null), foo);
        
        Collections.sort(foo, Comparators.nullsFirst(StringComparator.INSTANCE));
        assertEquals(list(null, null, "a", "b", "c", "d", "e", "f"), foo);
    }
    
}
