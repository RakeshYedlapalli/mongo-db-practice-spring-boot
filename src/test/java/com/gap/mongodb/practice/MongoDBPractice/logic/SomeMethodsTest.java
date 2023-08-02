package com.gap.mongodb.practice.MongoDBPractice.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SomeMethodsTest {
    @Test
    public void testReverse() {
        assertEquals("nI", SomeMethods.reverse("In"));
        assertThrows(IllegalArgumentException.class, () -> SomeMethods.reverse(null));
    }

    @Test
    public void testSwapNumbers() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SomeMethods.swapNumbers(1, 1);
    }

    @Test
    public void testStringContainsVowels() {
        assertTrue(SomeMethods.stringContainsVowels("Input"));
        assertTrue(SomeMethods.stringContainsVowels("foo"));
        assertTrue(SomeMethods.stringContainsVowels("xxaxx"));
        assertTrue(SomeMethods.stringContainsVowels(".*[aeiou].*"));
        assertFalse(SomeMethods.stringContainsVowels("42"));
    }

    @Test
    public void testIsPrime() {
        assertFalse(SomeMethods.isPrime(1));
        assertFalse(SomeMethods.isPrime(0));
        assertTrue(SomeMethods.isPrime(-1));
        assertTrue(SomeMethods.isPrime(2));
    }

    @Test
    public void testPrintFibonacciSeries() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SomeMethods.printFibonacciSeries(3);
    }
}

