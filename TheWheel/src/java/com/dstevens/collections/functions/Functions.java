package com.dstevens.collections.functions;

import java.util.Collection;

import static com.dstevens.structures.Pair.pair;

public class Functions {

    public static <E> E inject(Collection<E> elements, Function<E> operation) {
        E toReturn = operation.identity();
        for (E e : elements) {
            toReturn = operation.apply(pair(toReturn, e));
        }
        return toReturn;
    }
    
}
