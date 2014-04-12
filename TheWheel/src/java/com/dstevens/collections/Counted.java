package com.dstevens.collections;

import com.dstevens.structures.Pair;


public class Counted<CountedElement> extends Pair<CountedElement, Integer> implements Comparable<Counted<CountedElement>> {

    private Counted(CountedElement element, Integer value) {
        super(element, value);
    }

    public static <CountedElement> Counted<CountedElement> counted(CountedElement element, Integer value) {
        return new Counted<CountedElement>(element, value);
    }

    @Override
    public int compareTo(Counted<CountedElement> that) {
        return this.value - that.value;
    }

}
