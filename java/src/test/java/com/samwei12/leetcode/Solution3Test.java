package com.samwei12.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/3/5 2:44 PM
 */
public class Solution3Test {

    @Test
    public void lengthOfLongestSubstring() {
        int res = new Solution3().lengthOfLongestSubstring("abcabcbb");
        assertEquals(res, 3);

        res = new Solution3().lengthOfLongestSubstring("bbbbb");
        assertEquals(res, 1);

        res = new Solution3().lengthOfLongestSubstring("pwwkew");
        assertEquals(res, 3);

        res = new Solution3().lengthOfLongestSubstring("a");
        assertEquals(res, 1);

        res = new Solution3().lengthOfLongestSubstring("au");
        assertEquals(res, 2);
    }
}