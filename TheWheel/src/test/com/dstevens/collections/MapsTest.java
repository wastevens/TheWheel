package com.dstevens.collections;

import static com.dstevens.collections.Maps.map;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MapsTest {

    @Test
    public void testMap() {
        assertEquals(new HashMap<>(), map());
    }
    
}
