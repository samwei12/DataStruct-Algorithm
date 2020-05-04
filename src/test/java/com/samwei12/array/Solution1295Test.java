package com.samwei12.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/4 4:10 PM
 */
public class Solution1295Test {

    @Test
    public void findNumbers() {
        int[] nums = {12,345,2,6,7896};
        assertEquals(new Solution1295().findNumbers(nums), 2);
        assertEquals(new Solution1295().findNumbers(null), 0);

        int[] nums1 = {12,345,2,6,7896};
        assertEquals(new Solution1295().findNumbers(nums1), 2);
    }

    @Test
    public void calculateDigits() {
        assertEquals(Solution1295.calculateDigits(12), 2);
        assertEquals(Solution1295.calculateDigits(0), 1);
        assertEquals(Solution1295.calculateDigits(122), 3);
        assertEquals(Solution1295.calculateDigits(524323), 6);
    }
}