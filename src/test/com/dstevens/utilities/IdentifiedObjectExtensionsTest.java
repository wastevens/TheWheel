package com.dstevens.utilities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class IdentifiedObjectExtensionsTest {
    
    @Test
    public void testThatEqualsOnlyCaresAboutId() {
        SomeIdentified<String> a1 = new SomeIdentified<>("id", "not id 1");
        SomeIdentified<String> a2 = new SomeIdentified<>("id", "not id 2");
        SomeIdentified<String> a3 = new SomeIdentified<>("id 1", "not id 1");
        
        assertEquals(true, IdentifiedObjectExtensions.equals(a1, a1));
        assertEquals(true, IdentifiedObjectExtensions.equals(a1, a2));
        assertEquals(true, IdentifiedObjectExtensions.equals(a2, a1));
        
        assertEquals(false, ObjectExtensions.equals(a1, a2));
        assertEquals(false, ObjectExtensions.equals(a2, a1));
        
        assertEquals(false, IdentifiedObjectExtensions.equals(a1, a3));
    }
    
    @Test
    public void testThatEqualsHandlesNulls() {
        SomeIdentified<String> a1 = new SomeIdentified<>("id", "not id 1");
        
        assertEquals(false, IdentifiedObjectExtensions.equals(a1, null));
        assertEquals(false, IdentifiedObjectExtensions.equals(null, a1));
        assertEquals(false, IdentifiedObjectExtensions.equals(null, null));
    }
    
    @Test
    public void testThatEqualsReturnsFalseWhenClassesAreNotMutuallyAssignableEvenIfIdsAreEquals() {
        SomeIdentified<String> parent = new SomeIdentified<>("id", "not id 1");
        SomeIdentified<String> anEqualParent = new SomeIdentified<>("id", "not id 1");
        SomeIdentified<String> child = new ChildOfSomeIdentified<>("id", "not id 1");
        SomeIdentified<String> anEqualChild = new ChildOfSomeIdentified<>("id", "not id 1");
        
        assertEquals(true, IdentifiedObjectExtensions.equals(parent, anEqualParent));
        assertEquals(true, IdentifiedObjectExtensions.equals(child, anEqualChild));

        assertEquals(true, parent.getId().equals(child.getId()));
        
        assertEquals(false, IdentifiedObjectExtensions.equals(parent, child));
        assertEquals(false, IdentifiedObjectExtensions.equals(child, parent));
    }
    
    @Test
    public void testThatEqualsReturnsFalseWhenIdentifiersAreNotMutuallyAssignable() {
        SomeIdentified<String> a1  = new SomeIdentified<>("1", "2");
        SomeIdentified<String> a2  = new SomeIdentified<>("1", "3");
        SomeIdentified<Integer> a3 = new SomeIdentified<>(1, 1);
        
        assertEquals(true, IdentifiedObjectExtensions.equals(a1, a2));
        assertEquals(true, IdentifiedObjectExtensions.equals(a2, a1));
        
        assertEquals(false, IdentifiedObjectExtensions.equals(a1, a3));
        assertEquals(false, IdentifiedObjectExtensions.equals(a3, a1));
    }
    
    @Test
    public void testThatHashCodeReturnsHashOfIdOnly() {
        SomeIdentified<String> a1  = new SomeIdentified<>("Magical", "Boo");
        SomeIdentified<String> a2  = new SomeIdentified<>("Zippity", "Zoo");
        
        assertEquals("Magical".hashCode(), IdentifiedObjectExtensions.hashCodeFor(a1));
        assertEquals("Zippity".hashCode(), IdentifiedObjectExtensions.hashCodeFor(a2));
    }
    
    private static class SomeIdentified<E> implements Identified<E> {
        private final E id;
        @SuppressWarnings("unused")
        private final E notId;

        public SomeIdentified(E id, E notId) {
            this.id = id;
            this.notId = notId;
        }
        
        @Override
        public E getId() {
            return id;
        }
    }
    
    private static class ChildOfSomeIdentified<E> extends SomeIdentified<E> {

        public ChildOfSomeIdentified(E id, E notId) {
            super(id, notId);
        }
    }
    
    
}
