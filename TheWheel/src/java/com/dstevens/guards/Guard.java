package com.dstevens.guards;

public interface Guard<TypeToValidate, ExceptionToThrow extends Throwable> {

	void validate(TypeToValidate t) throws ExceptionToThrow;
	
}
