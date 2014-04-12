package com.dstevens.collections.functions;

public interface Operation<InputType, OutputType> {

    OutputType apply(InputType input);
}
