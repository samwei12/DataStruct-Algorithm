package com.samwei12.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 10:19 PM
 */
public class ListNodeTest {

    ListNode[] listNodes;

    @Before
    public void setUp() throws Exception {
        listNodes = new ListNode[6];

        listNodes[0] = null;

        ListNode node2 = new ListNode(1);
        listNodes[1] = node2;

        ListNode node3 = new ListNode(1);
        node3.next = new ListNode(2);
        listNodes[2] = node3;

        ListNode node4 = new ListNode(1);
        node4.next = new ListNode(2);
        node4.next.next = new ListNode(3);
        node4.next.next.next = new ListNode(4);
        node4.next.next.next.next = new ListNode(5);
        listNodes[3] = node4;

        ListNode node5 = new ListNode(1);
        node5.next = new ListNode(2);
        node5.next.next = new ListNode(4);
        listNodes[4] = node5;

        ListNode node6 = new ListNode(1);
        node6.next = new ListNode(3);
        node6.next.next = new ListNode(4);
        listNodes[5] = node6;
    }

    @Test
    public void printListNode() {
        ListNode.print(listNodes[0]);
        ListNode.print(listNodes[1]);
        ListNode.print(listNodes[2]);
        ListNode.print(listNodes[3]);
    }

    @Test
    public void reverseListNode() {
        ListNode.reverseListNode(listNodes[0]);
        ListNode.reverseListNode(listNodes[1]);
        ListNode.reverseListNode(listNodes[2]);
        ListNode.reverseListNode(listNodes[3]);
    }

    @Test
    public void getMidListNode() {
        ListNode.print(ListNode.getMidListNode(listNodes[0]));
        ListNode.print(ListNode.getMidListNode(listNodes[1]));
        ListNode.print(ListNode.getMidListNode(listNodes[2]));
        ListNode.print(ListNode.getMidListNode(listNodes[3]));
    }

    @Test
    public void removeNodeAtIndex() {
        ListNode.print(ListNode.removeNodeAtIndex(listNodes[3], 5));
        ListNode.print(ListNode.removeNodeAtIndex(listNodes[1], 1));
    }

    @Test
    public void mergeListNode() {
        final ListNode node = ListNode.mergeListNode(listNodes[4], listNodes[5]);
        ListNode.print(node);
    }
}