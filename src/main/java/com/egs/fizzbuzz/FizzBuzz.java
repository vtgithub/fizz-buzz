package com.egs.fizzbuzz;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FizzBuzz {

    public String getFizzBuzzString(long number){
        return LongStream.range(1, number+1)
                .mapToObj(operand -> getFizzBuzzDivisibleString(operand).orElse(String.valueOf(operand)))
                .collect(Collectors.joining(" "));
    }

    private Optional<String> getFizzBuzzDivisibleString(long number) {
        StringBuilder sb = new StringBuilder();
        getDivisionValue(number, 3, "Fizz").ifPresent(sb::append);
        getDivisionValue(number, 5, "Buzz").ifPresent(sb::append);
        return sb.toString().isEmpty() ? Optional.empty() : Optional.of(sb.toString());
    }

    private Optional<String> getDivisionValue(long number, int divisor, String value) {
        return  (number % divisor == 0) ? Optional.of(value) : Optional.empty();
    }
}
