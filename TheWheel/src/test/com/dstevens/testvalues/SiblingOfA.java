package com.dstevens.testvalues;

public class SiblingOfA extends ParentOfA {

    public SiblingOfA(String value) {
        super(value);
    }
    
    @Override
    public String toString() {
        return "SiblingOfA[" + getValue() + "]";
    }

}
