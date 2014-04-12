package com.dstevens.collections.functions;

public interface Matcher<E> {

    boolean matches(E thisElement, E thatElement);
    
}
