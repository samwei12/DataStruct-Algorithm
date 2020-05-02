package com.samwei12.basic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/3/22 2:14 PM
 */
public class MaxDivisorTest {

    @Test
    public void method1() {
        int x = MaxDivisor.method1(12, 42);
        assertEquals(x, 6);

        x = MaxDivisor.method1(12, 0);
        assertEquals(x, 0);

        x = MaxDivisor.method1(12, 13);
        assertEquals(x, 1);

        x = MaxDivisor.method1(12, 72);
        assertEquals(x, 12);

        x = MaxDivisor.method1(12, -72);
        assertEquals(x, 0);

        x = MaxDivisor.method1(123456789, 987654321);
        assertEquals(x, 9);
    }

    @Test
    public void method2() {
        int x = MaxDivisor.method1(12, 42);
        assertEquals(x, 6);

        x = MaxDivisor.method1(12, 0);
        assertEquals(x, 0);

        x = MaxDivisor.method1(12, 13);
        assertEquals(x, 1);

        x = MaxDivisor.method1(12, 72);
        assertEquals(x, 12);

        x = MaxDivisor.method1(12, -72);
        assertEquals(x, 0);

        x = MaxDivisor.method1(123456789, 987654321);
        assertEquals(x, 9);
    }
}