package com.dstevens.collections.functions;

import java.math.BigDecimal;

import com.dstevens.structures.Pair;

public abstract class Function<InputType> implements Operation<Pair<InputType, InputType>, InputType> {

    public abstract InputType identity();
    public abstract InputType apply(Pair<InputType, InputType> input);
    
    public static Function<Integer> integerSum() {
        return new Function<Integer>() {
            @Override
            public Integer identity() {
                return 0;
            }

            @Override
            public Integer apply(Pair<Integer, Integer> input) {
                return input.key + input.value;
            }
            
        };
    }
    
    public static Function<Integer> integerProduct() {
        return new Function<Integer>() {
            @Override
            public Integer identity() {
                return 1;
            }
            
            @Override
            public Integer apply(Pair<Integer, Integer> input) {
                return input.key * input.value;
            }
            
        };
    }
    
    public static Function<BigDecimal> decimalSum() {
        return new Function<BigDecimal>() {
            @Override
            public BigDecimal identity() {
                return BigDecimal.ZERO;
            }

            @Override
            public BigDecimal apply(Pair<BigDecimal, BigDecimal> input) {
                return input.key.add(input.value);
            }
            
        };
    }
    
    public static Function<BigDecimal> decimalProduct() {
        return new Function<BigDecimal>() {
            @Override
            public BigDecimal identity() {
                return BigDecimal.ONE;
            }
            
            @Override
            public BigDecimal apply(Pair<BigDecimal, BigDecimal> input) {
                return input.key.multiply(input.value);
            }
            
        };
    }
    
}
