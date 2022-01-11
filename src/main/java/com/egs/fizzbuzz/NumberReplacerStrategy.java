package com.egs.fizzbuzz;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class NumberReplacerStrategy {

    public String getNumberReplacedString(long number){
        return LongStream.range(1, number+1)
                .mapToObj(operand -> getDivisibleString(operand).orElse(String.valueOf(operand)))
                .collect(Collectors.joining(" "));
    }

    protected abstract Optional<String> getDivisibleString(long operand);

    protected Optional<String> getDivisionValue(long number, long divisor, String value) {
        return  (number % divisor == 0) ? Optional.of(value) : Optional.empty();
    }
}
