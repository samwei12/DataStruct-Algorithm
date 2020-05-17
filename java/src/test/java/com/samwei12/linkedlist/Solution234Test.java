package com.samwei12.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 4:00 PM
 */
public class Solution234Test {
    ListNode[] listNodes;

    @Before
    public void setUp() throws Exception {
        listNodes = new ListNode[3];

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(1);
        listNodes[0] = node1;

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(1);
        listNodes[1] = node2;
    }

    @Test
    public void isPalindrome() {
        assertTrue(new Solution234().isPalindrome(listNodes[0]));
        assertTrue(new Solution234().isPalindrome(listNodes[1]));
    }
}