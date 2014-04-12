package com.dstevens.collections;

import java.math.BigDecimal;
import java.util.*;

import com.dstevens.collections.functions.Operation;

import static com.dstevens.collections.Lists.listFrom;

import static com.dstevens.collections.functions.Operations.transform;

import static com.dstevens.collections.Evaluated.evaluated;

public class EvaluatedCollection<Element> extends BottomlessMap<Element, BigDecimal> {

    private EvaluatedCollection() {
        super(BigDecimal.ZERO);
    }
    
    private EvaluatedCollection(Collection<Evaluated<Element>> evaluatedElements) {
        super(BigDecimal.ZERO);
        for (Evaluated<Element> evaluated : evaluatedElements) {
            this.put(evaluated.key, evaluated.value);
        }
    }

    public static <Element> EvaluatedCollection<Element> evaluate() {
        return new EvaluatedCollection<Element>();
    }
    
    public static <Element> EvaluatedCollection<Element> evaluate(Collection<Element> elements, Operation<Element, Evaluated<Element>> evaluation) {
        return new EvaluatedCollection<Element>(transform(elements, evaluation));
    }
    
    public BigDecimal increment(Element value) {
        return addTo(value, BigDecimal.ONE);
    }
    
    public BigDecimal decrement(Element value) {
        return addTo(value, new BigDecimal(-1));
    }
    
    public BigDecimal addTo(Element value, BigDecimal addend) {
        return put(value, (get(value).add(addend)));
    }
    
    public List<Evaluated<Element>> getAscendingOrdered() {
        return listFrom(transform(entrySet(), toKeys()));
    }
    
    public List<Evaluated<Element>> getDescendingOrdered() {
        List<Evaluated<Element>> orderedElements = getAscendingOrdered();
        Collections.reverse(orderedElements);
        return orderedElements;
    }

    private Operation<Entry<Element, BigDecimal>, Evaluated<Element>> toKeys() {
        return new Operation<Entry<Element,BigDecimal>, Evaluated<Element>>() {
            @Override
            public Evaluated<Element> apply(Entry<Element, BigDecimal> input) {
                return evaluated(input.getKey(), input.getValue());
            }
        };
    }
}
