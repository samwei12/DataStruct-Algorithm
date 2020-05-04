package com.samwei12.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/4 3:07 PM
 */
public class Solution485Test {

    @Test
    public void findMaxConsecutiveOnes() {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int result = new Solution485().findMaxConsecutiveOnes(nums1);
        assertEquals(result, 3);

        result = new Solution485().findMaxConsecutiveOnes(null);
        assertEquals(result, 0);

        int[] nums2 = {1, 0, 0, 0, 0, 0};
        result = new Solution485().findMaxConsecutiveOnes(nums2);
        assertEquals(result, 1);
    }
}