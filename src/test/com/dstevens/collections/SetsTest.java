package com.dstevens.collections;

import static com.dstevens.collections.Sets.set;
import static com.dstevens.collections.Sets.setFrom;
import static com.dstevens.collections.Sets.setWith;
import static com.dstevens.collections.Sets.setWithout;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.dstevens.testvalues.A;
import com.dstevens.testvalues.ChildOfA;
import com.dstevens.testvalues.ParentOfA;

public class SetsTest {

    @Test
    public void testSetWithoutElements() {
        assertEquals(new HashSet<A>(), set());
    }
    
    @Test
    public void testSetWithElements() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        
        A anotherA1 = new A("1");
        A anotherA2 = new A("2");
        A anotherA3 = new A("3");
        Set<A> anotherSet = new HashSet<A>();
        anotherSet.add(anotherA1);
        anotherSet.add(anotherA2);
        anotherSet.add(anotherA3);
        
        assertEquals(anotherSet, set(a1, a2, a3));
    }
    
    @Test
    public void testSetWithLiskovSubstitution() {
        ParentOfA a1 = new A("1");
        ParentOfA a2 = new ParentOfA("2");
        ParentOfA a3 = new ChildOfA("3");
        
        ParentOfA anotherA1 = new A("1");
        ParentOfA anotherA2 = new ParentOfA("2");
        ParentOfA anotherA3 = new ChildOfA("3");
        Set<ParentOfA> aSet = set(a1, a2, a3);
        Set<ParentOfA> anotherSet = new HashSet<ParentOfA>();
        anotherSet.add(anotherA1);
        anotherSet.add(anotherA2);
        anotherSet.add(anotherA3);
        
        assertEquals(aSet, anotherSet);
    }
    
    @Test
    public void testSetFrom() {
        Set<A> set1 = set(new A("1"), new A("2"));
        Set<A> set2 = setFrom(set1);
        
        assertEquals(set1, set2);
        assertNotSame(set1, set2);
        
        A newElement = new A("3");
        set1.add(newElement);
        
        assertEquals(true, set1.contains(newElement));
        assertEquals(false, set2.contains(newElement));
        
        A anotherNewElement = new A("4");
        set2.add(anotherNewElement);
        
        assertEquals(false, set1.contains(anotherNewElement));
        assertEquals(true, set2.contains(anotherNewElement));
    }
    
    @Test
    public void testSetWith() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        A a4 = new A("4");
        Set<A> set1 = set(a1, a2);
        Set<A> set2 = setWith(set1, a3);
        set1.add(a4);

        assertEquals(set(a1, a2, a4), set1);
        assertEquals(set(a1, a2, a3), set2);
    }
    
    @Test
    public void testSetWithoutRemovingPresentElement() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        Set<A> set1 = set(a1, a2);
        Set<A> set2 = setWithout(set1, a2);
        set1.add(a3);
        
        assertEquals(set(a1, a2, a3), set1);
        assertEquals(set(a1), set2);
    }
    
    @Test
    public void testSetWithoutRemovingNotPresentElement() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        A a4 = new A("4");
        Set<A> set1 = set(a1, a2);
        Set<A> set2 = setWithout(set1, a4);
        set1.add(a3);
        
        assertEquals(set(a1, a2, a3), set1);
        assertEquals(set(a1, a2), set2);
    }
    
}
