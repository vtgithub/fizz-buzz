package com.egs.fizzbuzz;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzUnitTest {

    FizzBuzz fizzBuzz = new FizzBuzz();
    @Test
    void when_callGetFizzBuzzStringWithDivisibleBy3NumberAsInput_then_properNumberOfFizzShouldBeReturned(){
        String result = fizzBuzz.getFizzBuzzString(6);
        assertNotNull(result);
        assertEquals(2, StringUtils.countMatches(result, "Fizz"));
    }
    @Test
    void when_callGetFizzBuzzStringWithDivisibleBy5NumberAsInput_then_properNumberOfBuzzShouldBeReturned(){
        String result = fizzBuzz.getFizzBuzzString(25);
        assertNotNull(result);
        assertEquals(5, StringUtils.countMatches(result, "Buzz"));
    }
    @Test
    void when_callGetFizzBuzzStringWithDivisibleBy15NumberAsInput_then_properNumberOfFizzBuzzShouldBeReturned(){
        String result = fizzBuzz.getFizzBuzzString(30);
        assertNotNull(result);
        assertEquals(2, StringUtils.countMatches(result, "FizzBuzz"));
    }

    @Test
    void when_callGetFizzBuzzStringWithDivisibleBy15NumberAsInput_then_properNumberOfFizzAndBuzzShouldBeReturned(){
        String result = fizzBuzz.getFizzBuzzString(30);
        assertNotNull(result);
        assertEquals(10, StringUtils.countMatches(result, "Fizz"));
        assertEquals(6, StringUtils.countMatches(result, "Buzz"));
    }
    @Test
    void when_callGetFizzBuzzStringWithNonDivisibleBy3Or5NumberAsInput_then_noFizzNorBuzzShouldBeReturned(){
        String result = fizzBuzz.getFizzBuzzString(2);
        assertNotNull(result);
        assertEquals(0, StringUtils.countMatches(result, "Fizz"));
        assertEquals(0, StringUtils.countMatches(result, "Buzz"));
    }
}
