package com.dstevens.collections;

import java.util.function.Function;

public class Transformations {

	public static <Input, Output> Output nullableMap(Input in, Function<Input, Output> function) {
		return in == null ? null : function.apply(in);
	}
	
}
