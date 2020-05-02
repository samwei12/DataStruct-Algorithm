package com.samwei12.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 6:31 PM
 */
public class Solution9Test {

    @Test
    public void isPalindrome() {
        assertTrue(new Solution9().isPalindrome(121));
        assertFalse(new Solution9().isPalindrome(10));
        assertFalse(new Solution9().isPalindrome(123));
        assertTrue(new Solution9().isPalindrome(313));
        assertTrue(new Solution9().isPalindrome(1001));
        assertFalse(new Solution9().isPalindrome(1000021));
    }
}