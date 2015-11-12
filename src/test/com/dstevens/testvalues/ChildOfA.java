package com.dstevens.testvalues;

public class ChildOfA extends A {

    public ChildOfA(String value) {
        super(value);
    }
    
    @Override
    public String toString() {
        return "SiblingOfA[" + getValue() + "]";
    }
    
}
