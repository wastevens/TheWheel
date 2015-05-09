package com.dstevens.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Sets {

    public static <E> Set<E> set() {
        return new HashSet<E>();
    }
    
    public static <E extends Enum<E>> EnumSet<E> enumSet(Class<E> enumKlazz) {
    	return EnumSet.noneOf(enumKlazz);
    }
    
    public static <E extends Enum<E>> EnumSet<E> enumSetAllOf(Class<E> enumKlazz) {
    	return EnumSet.allOf(enumKlazz);
    }
    
    @SafeVarargs
    public static <E extends Enum<E>> EnumSet<E> enumSet(E enum1, E... enumRest) {
    	return EnumSet.of(enum1, enumRest);
    }
    
    @SafeVarargs
    public static <E> Set<E> set(E... elements) {
        return setFrom(Arrays.asList(elements));
    }
    
    public static <E> Set<E> setFrom(Iterable<E> elements) {
        Set<E> set = set();
        elements.forEach((E e) -> set.add(e));
        return set;
    }
    
    @SafeVarargs
    public static <E> Set<E> setWith(Collection<E> elements, E... elementsToAdd) {
        Set<E> setFrom = setFrom(elements);
        setFrom.addAll(set(elementsToAdd));
        return setFrom;
    }
    
    @SafeVarargs
    public static <E> Set<E> setWithout(Collection<E> elements, E... elementsToRemove) {
        Set<E> setFrom = setFrom(elements);
        setFrom.removeAll(set(elementsToRemove));
        return setFrom;
    }
    
    public static <E> Set<E> setWithout(Collection<E> elements, Predicate<? super E> matches) {
        Set<E> setFrom = setFrom(elements);
        setFrom.removeIf(matches);
        return setFrom;
    }
}
