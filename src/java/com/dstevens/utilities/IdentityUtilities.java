package com.dstevens.utilities;

public class IdentityUtilities {

	@SuppressWarnings("unchecked")
	public static <F, E extends Identified<F>> E withId(F id, E... values) {
		for (E e : values) {
			if(id.equals(e.getId())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Could not find a value with id " + id);
	}
	
	@SuppressWarnings("unchecked")
	public static <E extends Identified<Integer>> E withId(Integer id, E... values) {
		for (E e : values) {
			if(id == e.getId()) {
				return e;
			}
		}
		throw new IllegalArgumentException("Could not find a value with id " + id);
	}
	
	public static <F, E extends Identified<F>> E withId(F id, Iterable<E> values) {
		for (E e : values) {
			if(id.equals(e.getId())) {
				return e;
			}
		}
		throw new IllegalArgumentException("Could not find a value with id " + id);
	}
	
	public static <E extends Identified<Integer>> E withId(Integer id, Iterable<E> values) {
		for (E e : values) {
			if(id == e.getId()) {
				return e;
			}
		}
		throw new IllegalArgumentException("Could not find a value with id " + id);
	}
	
}
