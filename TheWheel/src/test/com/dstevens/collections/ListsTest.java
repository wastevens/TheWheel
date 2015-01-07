package com.dstevens.collections;

import static com.dstevens.collections.Lists.first;
import static com.dstevens.collections.Lists.last;
import static com.dstevens.collections.Lists.list;
import static com.dstevens.collections.Lists.listFrom;
import static com.dstevens.collections.Lists.listWith;
import static com.dstevens.collections.Lists.listWithout;
import static com.dstevens.collections.Lists.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dstevens.testvalues.A;
import com.dstevens.testvalues.ChildOfA;
import com.dstevens.testvalues.ParentOfA;

public class ListsTest {

    @Test
    public void testListWithoutElements() {
        assertEquals(new ArrayList<A>(), list());
    }
    
    @Test
    public void testListWithElements() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        
        A anotherA1 = new A("1");
        A anotherA2 = new A("2");
        A anotherA3 = new A("3");
        List<A> anotherList = new ArrayList<A>();
        anotherList.add(anotherA1);
        anotherList.add(anotherA2);
        anotherList.add(anotherA3);
        
        assertEquals(anotherList, list(a1, a2, a3));
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
    
    @Test
    public void testListWithoutRemovingPresentElement() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        List<A> list1 = list(a1, a2);
        List<A> list2 = listWithout(list1, a2);
        list1.add(a3);
        
        assertEquals(list(a1, a2, a3), list1);
        assertEquals(list(a1), list2);
    }
    
    @Test
    public void testListWithoutRemovingNotPresentElement() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        A a4 = new A("4");
        List<A> list1 = list(a1, a2);
        List<A> list2 = listWithout(list1, a4);
        list1.add(a3);
        
        assertEquals(list(a1, a2, a3), list1);
        assertEquals(list(a1, a2), list2);
    }
    
    @Test
    public void testSort() {
        SomeComparable a = new SomeComparable("a");
        SomeComparable b = new SomeComparable("b");
        SomeComparable c = new SomeComparable("c");
        
        List<SomeComparable> unsorted = list(b, c, a);
        List<SomeComparable> sorted = sort(unsorted);
        
        assertEquals(list(b,c,a), unsorted);
        assertEquals(list(a,b,c), sorted);
    }
    
    @Test
    public void testFirstAndLast() {
        A a1 = new A("1");
        A a2 = new A("2");
        A a3 = new A("3");
        
        List<A> list = list(a1, a2, a3);
        
        assertEquals(a1, first(list));
        assertEquals(a3, last(list));
    }
    
    private static class SomeComparable implements Comparable<SomeComparable> {
        public final String value;
        public SomeComparable(String value) {
            this.value = value;
        }
        @Override
        public int compareTo(SomeComparable that) {
            return this.value.compareTo(that.value);
        }
    }
}
