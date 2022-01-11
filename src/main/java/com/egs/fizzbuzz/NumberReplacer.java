package com.egs.fizzbuzz;

import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public class NumberReplacer extends NumberReplacerStrategy {

    private SortedMap<Long, String> substitutionMap;

    private NumberReplacer(){}

    public NumberReplacer(SortedMap<Long, String> substitutionMap) {
        this.substitutionMap = Objects.nonNull(substitutionMap) ? substitutionMap : new TreeMap<>();
    }

    @Override
    protected Optional<String> getDivisibleString(long operand) {
        StringBuilder sb = new StringBuilder();
        substitutionMap.forEach((divisor, value) -> getDivisionValue(operand, divisor, value).ifPresent(sb::append));
        return sb.toString().isEmpty() ? Optional.empty() : Optional.of(sb.toString());
    }
}
