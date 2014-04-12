package com.dstevens.collections.functions;

import static com.dstevens.collections.Lists.*;
import static com.dstevens.collections.Maps.map;

import java.util.*;

import com.dstevens.structures.Pair;
import com.dstevens.structures.optional.Optional;

public class Operations {

    public static <E> Collection<E> shuffle(Collection<E> elements) {
        List<E> list = listFrom(elements);
        Collections.shuffle(list);
        return list;
    }
    
    public static <E, F> Collection<F> transform(Collection<E> elements, Operation<E, F> operation) {
        List<F> list = list();
        for (E e : elements) {
            list.add(operation.apply(e));
        }
        return list;
    }
    
    public static <E, Key, Value> Map<Key, Value> transformToMap(Collection<E> elements, Operation<E, Pair<Key, Value>> operation) {
        Map<Key, Value> toReturn = map();
        for (E e : elements) {
            Pair<Key, Value> apply = operation.apply(e);
            toReturn.put(apply.key, apply.value);
        }
        return toReturn;
    }
    
    public static <E> Collection<E> filter(Collection<E> elements, Predicate<? super E> operation) {
        List<E> list = list();
        for (E e : elements) {
            if (operation.apply(e)) {
                list.add(e);
            }
        }
        return list;
    }
    
    public static <E> Optional<E> findFirst(Collection<E> elements, Predicate<? super E> function) {
        for (E e : elements) {
            if (function.apply(e)) {
                return Optional.withValue(e);
            }
        }
        return Optional.withoutValue();
    }
    
    public static <E> Collection<E> remove(Collection<E> elements, Predicate<? super E> function) {
        List<E> list = list();
        for (E e : elements) {
            if (!function.apply(e)) {
                list.add(e);
            }
        }
        return list;
    }
    
    public static <E> boolean allAre(Collection<? extends E> elements, Predicate<? super E> predicate) {
        return filter(elements, predicate).size() == elements.size();
    }
    
    public static <E> boolean areAny(Collection<? extends E> elements, Predicate<? super E> predicate) {
        return !filter(elements, predicate).isEmpty();
    }
    
    public static <E> int count(Collection<? extends E> elements, Predicate<? super E> predicate) {
        return filter(elements, predicate).size();
    }
    
    public static <E> Collection<E> flatten(Collection<Collection<E>> elements) {
        List<E> toReturn = list();
        for (Collection<E> listOfElements : elements) {
            for (E e : listOfElements) {
                toReturn.add(e);
            }
        }
        return toReturn;
    }
    
    public static <E> Optional<E> greatest(Collection<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.withoutValue();
        }
        List<E> sortedElements = listFrom(elements);
        Collections.sort(sortedElements, comparator);
        return Optional.withValue(sortedElements.get(sortedElements.size()-1));
    }
    
    public static <E> Optional<E> least(Collection<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.withoutValue();
        }
        List<E> sortedElements = listFrom(elements);
        Collections.sort(sortedElements, comparator);
        return Optional.withValue(sortedElements.get(0));
    }
}
