package com.dstevens.testvalues;

public class A extends ParentOfA {

    public A(String value) {
        super(value);
    }
    
    @Override
    public String toString() {
        return "A[" + getValue() + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof A) {
            A that = (A) o;
            return this.getValue().equals(that.getValue());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 17;
    }
    
}
