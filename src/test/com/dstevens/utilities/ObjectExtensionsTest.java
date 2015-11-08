package com.dstevens.utilities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

@SuppressWarnings("all")
public class ObjectExtensionsTest {

    @Test
    public void testEqualsOfFields() {
        GrandParentOfA.grandParentValue = 2;
        A o1 = new A("foo", "bar", "baz", "baq", "nab");
        
        assertEquals(true, ObjectExtensions.equals(o1, o1));
        assertEquals(ObjectExtensions.hashCodeFor(o1), ObjectExtensions.hashCodeFor(o1));
        assertEquals(true, ObjectExtensions.equals(o1, new A("foo", "bar", "baz", "baq", "nab")));
        assertEquals(ObjectExtensions.hashCodeFor(o1), ObjectExtensions.hashCodeFor(new A("foo", "bar", "baz", "baq", "nab")));
        
        assertEquals(false, ObjectExtensions.equals(o1, new A("another foo", "bar", "baz", "baq", "nab")));
        assertEquals(false, ObjectExtensions.equals(o1, new A("foo", "another bar", "baz", "baq", "nab")));
        assertEquals(false, ObjectExtensions.equals(o1, new A("foo", "bar", "another baz", "baq", "nab")));
        assertEquals(false, ObjectExtensions.equals(o1, new A("foo", "bar", "baz", "another baq", "nab")));
        assertEquals(false, ObjectExtensions.equals(o1, new A("foo", "bar", "baz", "baq", "another nab")));
        
        assertEquals(false, ObjectExtensions.equals(o1, new A("baq", "baz", "nab", "foo", "bar")));
        
        A o2 = new A("parent foo", "foo", "bar", "baz", "baq", "nab");
        assertEquals(false, ObjectExtensions.equals(o1, o2));
    }
    
    @Test
    public void testEqualsOfArrayFields() {
        B emptyArray = new B();
        B populatedArray = new B("foo", "bar", "baz");
        
        assertEquals(true, ObjectExtensions.equals(emptyArray, emptyArray));
        assertEquals(ObjectExtensions.hashCodeFor(emptyArray), ObjectExtensions.hashCodeFor(emptyArray));
        assertEquals(true, ObjectExtensions.equals(emptyArray, new B()));
        assertEquals(ObjectExtensions.hashCodeFor(emptyArray), ObjectExtensions.hashCodeFor(new B()));
        assertEquals(true, ObjectExtensions.equals(populatedArray, populatedArray));
        assertEquals(ObjectExtensions.hashCodeFor(populatedArray), ObjectExtensions.hashCodeFor(populatedArray));
        assertEquals(true, ObjectExtensions.equals(populatedArray, new B("foo", "bar", "baz")));
        assertEquals(ObjectExtensions.hashCodeFor(populatedArray), ObjectExtensions.hashCodeFor(new B("foo", "bar", "baz")));
        
        assertEquals(false, ObjectExtensions.equals(emptyArray, new B(null)));
        assertEquals(false, ObjectExtensions.equals(populatedArray, new B("foo", "bar")));
        assertEquals(false, ObjectExtensions.equals(populatedArray, new B("foo", "bar", "baz", "baq")));
        assertEquals(false, ObjectExtensions.equals(populatedArray, new B("bar", "baz", "foo")));
    }
    
    @Test
    public void testEqualsOfPrimitiveArrayFields() {
        C emptyArray = new C();
        C populatedArray = new C(1, 2, 3);
        
        assertEquals(true, ObjectExtensions.equals(emptyArray, emptyArray));
        assertEquals(ObjectExtensions.hashCodeFor(emptyArray), ObjectExtensions.hashCodeFor(emptyArray));
        assertEquals(true, ObjectExtensions.equals(emptyArray, new C()));
        assertEquals(ObjectExtensions.hashCodeFor(emptyArray), ObjectExtensions.hashCodeFor(new C()));
        assertEquals(true, ObjectExtensions.equals(populatedArray, populatedArray));
        assertEquals(ObjectExtensions.hashCodeFor(populatedArray), ObjectExtensions.hashCodeFor(populatedArray));
        assertEquals(true, ObjectExtensions.equals(populatedArray, new C(1, 2, 3)));
        assertEquals(ObjectExtensions.hashCodeFor(populatedArray), ObjectExtensions.hashCodeFor(new C(1, 2, 3)));
        
        assertEquals(false, ObjectExtensions.equals(populatedArray, new C(1, 2)));
        assertEquals(false, ObjectExtensions.equals(populatedArray, new C(1, 2, 3, 4)));
        assertEquals(false, ObjectExtensions.equals(populatedArray, new C(2, 3, 1)));
    }
    
    @Test
    public void testEqualsOfPrivateStaticFields() {
        assertEquals(true, ObjectExtensions.equals(new GrandParentOfA(), new GrandParentOfA()));
        assertEquals(ObjectExtensions.hashCodeFor(new GrandParentOfA()), ObjectExtensions.hashCodeFor(new GrandParentOfA()));
        GrandParentOfA.grandParentValue = 3;
        assertEquals(true, ObjectExtensions.equals(new GrandParentOfA(), new GrandParentOfA()));
        assertEquals(ObjectExtensions.hashCodeFor(new GrandParentOfA()), ObjectExtensions.hashCodeFor(new GrandParentOfA()));
    }
    
    @Test
    public void testEqualsOfMutualAssignability() {
        assertEquals(false, ObjectExtensions.equals(new GrandParentOfA(), new ParentOfA("")));
        assertEquals(false, ObjectExtensions.equals(new ParentOfA(""), new GrandParentOfA()));
    }
    
    @Test
    public void testToString() {
        assertEquals("ObjectExtensionsTest.GrandParentOfA[]", ObjectExtensions.toStringFor(new GrandParentOfA()));
        assertEquals("ObjectExtensionsTest.A[privateFinalField=foo,privateField=bar,defaultField=baz,protectedField=baq,publicField=nab,privateFinalFieldOnParent=]", ObjectExtensions.toStringFor(new A("foo", "bar", "baz", "baq", "nab")));
        assertEquals("ObjectExtensionsTest.B[values={foo,bar,baz,baq,nab}]", ObjectExtensions.toStringFor(new B("foo", "bar", "baz", "baq", "nab")));
        assertEquals("ObjectExtensionsTest.C[values={1,2,3}]", ObjectExtensions.toStringFor(new C(1, 2, 3)));
    }
    
    private static class GrandParentOfA {
        private static int grandParentValue; 
    }
    
    private static class ParentOfA extends GrandParentOfA {
        private final String privateFinalFieldOnParent;
        
        public ParentOfA(String privateFinalFieldOnParent) {
            this.privateFinalFieldOnParent = privateFinalFieldOnParent;
        }
    }
    
    private static class A extends ParentOfA {
        private final String privateFinalField;
        private String privateField;
        String defaultField;
        protected String protectedField;
        public String publicField;
        
        public A(String privateFinalField, String privateField, String defaultField, String protectedField, String publicField) {
            super("");
            this.privateFinalField = privateFinalField;
            this.privateField = privateField;
            this.defaultField = defaultField;
            this.protectedField = protectedField;
            this.publicField = publicField;
        }
        
        public A(String privateFinalFieldOnParent, String privateFinalField, String privateField, String defaultField, String protectedField, String publicField) {
            super(privateFinalFieldOnParent);
            this.privateFinalField = privateFinalField;
            this.privateField = privateField;
            this.defaultField = defaultField;
            this.protectedField = protectedField;
            this.publicField = publicField;
        }
    }        
    
    private static class B {
        private String[] values;

        public B(String... values) {
            this.values = values;
        }
    }
    
    private static class C {
        private int[] values;
        
        public C(int... values) {
            this.values = values;
        }
    }
    
    
    
}
