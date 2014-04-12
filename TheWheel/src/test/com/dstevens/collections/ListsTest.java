package com.dstevens.collections;

import static com.dstevens.collections.Lists.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.dstevens.testvalues.*;

public class ListsTest {

    @Test
    public void testListWithoutElements() {
        List<A> aList = list();
        List<A> anotherList = new ArrayList<A>();
        
        assertEquals(aList, anotherList);
    }
    
    @Test
    public void testListWithElements() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        
        A anotherA1 = new A("1");
        A anotherA2 = new A("2");
        A anotherA3 = new A("3");
        List<A> aList = list(a1, a2, a3);
        List<A> anotherList = new ArrayList<A>();
        anotherList.add(anotherA1);
        anotherList.add(anotherA2);
        anotherList.add(anotherA3);
        
        assertEquals(aList, anotherList);
    }
    
    @Test
    public void testListWithLiskovSubstitution() {
        ParentOfA a1 = new A("1");
        ParentOfA a2 = new ParentOfA("2");
        ParentOfA a3 = new ChildOfA("3");
        
        ParentOfA anotherA1 = new A("1");
        ParentOfA anotherA2 = new ParentOfA("2");
        ParentOfA anotherA3 = new ChildOfA("3");
        List<ParentOfA> aList = list(a1, a2, a3);
        List<ParentOfA> anotherList = new ArrayList<ParentOfA>();
        anotherList.add(anotherA1);
        anotherList.add(anotherA2);
        anotherList.add(anotherA3);
        
        assertEquals(aList, anotherList);
    }
    
    @Test
    public void testListWithLiskovSubstitution2() {
        List<A> listA = list();
        listA.add(new ChildOfA("1"));
        listA.add(new A("2"));
    }
    
    @Test
    public void testListFrom() {
        List<A> list1 = list(new A("1"), new A("2"));
        List<A> list2 = listFrom(list1);
        
        assertEquals(list1, list2);
        assertNotSame(list1, list2);
        
        A newElement = new A("3");
        list1.add(newElement);
        
        assertEquals(true, list1.contains(newElement));
        assertEquals(false, list2.contains(newElement));
        
        A anotherNewElement = new A("4");
        list2.add(anotherNewElement);
        
        assertEquals(false, list1.contains(anotherNewElement));
        assertEquals(true, list2.contains(anotherNewElement));
    }
    
    @Test
    public void testListWith() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        A a4 = new A("4");
        List<A> list1 = list(a1, a2);
        List<A> list2 = listWith(list1, a3);
        list1.add(a4);

        assertEquals(list(a1, a2, a4), list1);
        assertEquals(list(a1, a2, a3), list2);
    }
    
}
