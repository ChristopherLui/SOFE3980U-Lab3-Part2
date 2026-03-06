package com.ontariotechu.sofe3980U;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryOperationsTest {

    @Test
    public void testAndNormal() {
        Binary a = new Binary("1101");
        Binary b = new Binary("1011");
        Binary result = Binary.and(a, b);
        assertEquals("1001", result.getValue());
    }

    @Test
    public void testAndWithZero() {
        Binary a = new Binary("1101");
        Binary b = new Binary("0");
        Binary result = Binary.and(a, b);
        assertEquals("0000".replaceAll("^0+", "0"), result.getValue());
    }

    @Test
    public void testAndDifferentLengths() {
        Binary a = new Binary("101");
        Binary b = new Binary("1111");
        Binary result = Binary.and(a, b);
        assertEquals("101", result.getValue());
    }

    @Test
    public void testOrNormal() {
        Binary a = new Binary("1100");
        Binary b = new Binary("1010");
        Binary result = Binary.or(a, b);
        assertEquals("1110", result.getValue());
    }

    @Test
    public void testOrWithZero() {
        Binary a = new Binary("1011");
        Binary b = new Binary("0");
        Binary result = Binary.or(a, b);
        assertEquals("1011", result.getValue());
    }

    @Test
    public void testOrDifferentLengths() {
        Binary a = new Binary("11");
        Binary b = new Binary("1010");
        Binary result = Binary.or(a, b);
        assertEquals("1011", result.getValue());
    }

    @Test
    public void testMultiplyNormal() {
        Binary a = new Binary("101");
        Binary b = new Binary("11");
        Binary result = Binary.multiply(a, b);
        assertEquals("1111", result.getValue());
    }

    @Test
    public void testMultiplyWithZero() {
        Binary a = new Binary("1011");
        Binary b = new Binary("0");
        Binary result = Binary.multiply(a, b);
        assertEquals("0", result.getValue());
    }

    @Test
    public void testMultiplyLargeNumbers() {
        Binary a = new Binary("110");
        Binary b = new Binary("101");
        Binary result = Binary.multiply(a, b);
        assertEquals("11110", result.getValue());
    }
}
