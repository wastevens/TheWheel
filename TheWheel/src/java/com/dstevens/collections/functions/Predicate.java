package com.dstevens.collections.functions;

import java.util.Collection;

public abstract class Predicate<InputType> implements Operation<InputType, Boolean> {

    public final Predicate<InputType> and(final Predicate<? super InputType> andPredicate) {
        return new Predicate<InputType>() {
            @Override
            public Boolean apply(InputType input) {
                return Predicate.this.apply(input) && andPredicate.apply(input);
            }
        };
    }
    
    public final Predicate<InputType> or(final Predicate<? super InputType> orPredicate) {
        return new Predicate<InputType>() {
            @Override
            public Boolean apply(InputType input) {
                return Predicate.this.apply(input) || orPredicate.apply(input);
            }
        };
    }
    
    public static <InputType> Predicate<InputType> not(final Predicate<? super InputType> predicate) {
        return new Predicate<InputType>() {
            @Override
            public Boolean apply(InputType input) {
                return !predicate.apply(input);
            }
        };
    }
    
    public static <E> Predicate<E> in(final Collection<? extends E> c) {
        return new Predicate<E>() {
            @Override
            public Boolean apply(E t) {
                return c.contains(t);
            }
        };
    }
    
    public static <E> Predicate<E> in(final Collection<? extends E> collection, final Matcher<? super E> matcher) {
        return new Predicate<E>() {
            @Override
            public Boolean apply(E targetElement) {
                for (E collectionElement : collection) {
                    if (matcher.matches(collectionElement, targetElement)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
}
