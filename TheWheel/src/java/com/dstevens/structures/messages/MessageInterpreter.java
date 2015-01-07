package com.dstevens.structures.messages;

import java.util.function.Function;

public interface MessageInterpreter extends Function<Message, String> {

    String apply(Message message);
    
}
