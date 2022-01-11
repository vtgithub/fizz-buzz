package com.egs.fizzbuzz;

import java.util.Optional;

public class FizzBuzz extends NumberReplacerStrategy {

    protected Optional<String> getDivisibleString(long operand) {
        StringBuilder sb = new StringBuilder();
        getDivisionValue(operand, 3, "Fizz").ifPresent(sb::append);
        getDivisionValue(operand, 5, "Buzz").ifPresent(sb::append);
        return sb.toString().isEmpty() ? Optional.empty() : Optional.of(sb.toString());
    }

}
