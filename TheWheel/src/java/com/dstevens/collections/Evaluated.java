package com.dstevens.collections;

import java.math.BigDecimal;

import com.dstevens.structures.Pair;

public class Evaluated<EvaluatedElement> extends Pair<EvaluatedElement, BigDecimal> implements Comparable<Evaluated<EvaluatedElement>> {

    private Evaluated(EvaluatedElement element, BigDecimal value) {
        super(element, value);
    }

    public static <EvaluatedElement> Evaluated<EvaluatedElement> evaluated(EvaluatedElement element, BigDecimal value) {
        return new Evaluated<EvaluatedElement>(element, value);
    }
    
    public static <EvaluatedElement> Evaluated<EvaluatedElement> evaluated(EvaluatedElement element, Integer value) {
        return new Evaluated<EvaluatedElement>(element, new BigDecimal(value));
    }

    @Override
    public int compareTo(Evaluated<EvaluatedElement> that) {
        return this.value.compareTo(that.value);
    }
    
}
