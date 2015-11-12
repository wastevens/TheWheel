package com.dstevens.testvalues;

public class ParentOfA {

    private final String value;

    public ParentOfA(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "ParentOfA[" + value + "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof ParentOfA) {
            ParentOfA that = (ParentOfA) o;
            return this.value.equals(that.value);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 17;
    }
    
}
