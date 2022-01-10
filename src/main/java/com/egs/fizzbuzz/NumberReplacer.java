package com.egs.fizzbuzz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class NumberReplacer {

    private SortedMap<Long, String> substitutionMap;

    private NumberReplacer(){}

    public NumberReplacer(SortedMap<Long, String> substitutionMap) {
        this.substitutionMap = Objects.nonNull(substitutionMap) ? substitutionMap : new TreeMap<>();
    }

    public void setSubstitutionMap(SortedMap<Long, String> substitutionMap) {
        this.substitutionMap = substitutionMap;
    }

    public String getNumberReplacedString(long number){
        return LongStream.range(1, number+1)
                .mapToObj(operand -> getDivisibleString(operand).orElse(String.valueOf(operand)))
                .collect(Collectors.joining(" "));
    }

    private Optional<String> getDivisibleString(long operand) {
        StringBuilder sb = new StringBuilder();
        substitutionMap.forEach((divisor, value) -> getDivisionValue(operand, divisor, value).ifPresent(sb::append));
        return sb.toString().isEmpty() ? Optional.empty() : Optional.of(sb.toString());
    }

    private Optional<String> getDivisionValue(long number, long divisor, String value) {
        return  (number % divisor == 0) ? Optional.of(value) : Optional.empty();
    }
}
