package com.samwei12.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 3:42 PM
 * @link https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Solution234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        //   1. 空链表直接返回 true
        if (head == null || head.next == null) {
            return true;
        }

        return solution3(head);
    }


    /**
     * 模拟使用一个栈来完成
     * @param head 头结点
     * @return 时间复杂度 O(n) 空间复杂度 O(n)
     */
    public boolean solution1(ListNode head) {
        // 模拟一个栈进行处理
        ListNode ref = head;
        LinkedList<Integer> stack = new LinkedList<>();
        // 2. 遍历入栈
        while (true) {
            stack.addFirst(ref.val);
            if (ref.next == null) {
                break;
            }
            ref = ref.next;
        }

        // 3. 遍历出栈对比
        ref = head;
        while (true) {
            final Integer removeFirst = stack.removeFirst();
            if (removeFirst != ref.val) {
                return false;
            }

            if (ref.next == null) {
                break;
            }
            ref = ref.next;
        }
        return true;
    }

    /**
     * 使用普通数组
     * @param head 头结点
     * @return 时间复杂度 O(n) 空间复杂度 O(n)
     */
    public boolean solution2(ListNode head) {
        // 模拟一个栈进行处理
        ListNode ref = head;
        ArrayList<Integer> list = new ArrayList<>();
        // 2. 遍历入栈
        while (true) {
            list.add(ref.val);
            if (ref.next == null) {
                break;
            }
            ref = ref.next;
        }

        ref = head;
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) != ref.val) {
                return false;
            }
            ref = ref.next;
        }
        return true;
    }

    /**
     * 思路：使用快慢两个指针，快指针每次步进两格，慢指针每次步进一格，当快指针的 next 或者再下一个为 null 则停止，代表找到中间的结点，过程中，慢指针进行逆序，这样在找到中间结点时候，前半部分整体逆序，此时进行前后两部分的遍历比对
     * @param head 头结点
     * @return 时间复杂度 O(n) 空间复杂度 O(1)
     */
    public boolean solution3(ListNode head) {
        ListNode slower = head;
        ListNode faster = head;
        ListNode temp;

        // 查找中间结点的过程中，逐步逆序前半部分
        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;

            temp = head;
            head = slower.next;
            slower.next = head.next;
            head.next = temp;
        }
        // 遍历前后两部分链表

        // 代表链表长度不是偶数
        if (faster.next == null) {
            while (slower.next != null) {
                if (head.next.val != slower.next.val) {
                    return false;
                }
                head = head.next;
                slower = slower.next;
            }
            return head.val == slower.val;
        }

        else {
            while (slower.next != null) {
                if (head.val != slower.next.val) {
                    return false;
                }
                head = head.next;
                slower = slower.next;
            }
        }

        return true;
    }
}