package com.egs.fizzbuzz;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NumberReplacerUnitTest {

    @Test
    void given_divisorMap_when_callGetNumberReplacedString_then_properDivisorMapValuesShouldBeReplaced(){
        new TreeMap<>(){{put(3L, "Fizz"); put(5L, "Buzz");}};
        NumberReplacer numberReplacer = new NumberReplacer(new TreeMap<>(){{put(3L, "Fizz"); put(5L, "Buzz");}});
        String result = numberReplacer.getNumberReplacedString(15);
        assertNotNull(result);
        assertEquals(5, StringUtils.countMatches(result, "Fizz"));
        assertEquals(3, StringUtils.countMatches(result, "Buzz"));
    }

    @Test
    void given_divisorMap_when_callGetNumberReplacedString_then_properCombinationOfDivisorMapValuesShouldBeReplaced(){
        NumberReplacer numberReplacer = new NumberReplacer(new TreeMap<>(){{put(3L, "Fizz"); put(5L, "Buzz");}});
        String result = numberReplacer.getNumberReplacedString(30);
        assertNotNull(result);
        assertEquals(2, StringUtils.countMatches(result, "FizzBuzz"));
    }

    @Test
    void given_EmptyDivisorMap_when_callGetNumberReplacedString_then_nonOfNumbersShouldBeReplaced(){
        NumberReplacer numberReplacer = new NumberReplacer(new TreeMap<>());
        String result = numberReplacer.getNumberReplacedString(10);
        assertNotNull(result);
        System.out.println(result);
        assertEquals(10, result.split(" ").length);
    }
}
