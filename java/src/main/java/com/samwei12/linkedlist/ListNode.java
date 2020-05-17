package com.samwei12.linkedlist;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 3:43 PM
 * 单向链表
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 返回链表长度
     *
     * @return 链表长度
     */
    public static int getSize(ListNode head) {
        if (head == null) {
            return -1;
        }
        ListNode temp = head;
        int res = 0;
        while (temp.next != null) {
            temp = temp.next;
            res++;
        }
        res++;
        return res;
    }

    /**
     * 遍历打印链表
     */
    public static void print(ListNode head) {
        if (head == null) {
            System.out.print("null\n");
            System.out.println("------");
            return;
        }

        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print(temp.val + "->");
        System.out.print("null\n");
        System.out.println("------");
        System.out.println();
    }

    /**
     * 反转指定链表
     *
     * @param head 头结点
     */
    public static void reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        System.out.println("Before: ");
        ListNode.print(head);

        /* 这个方法不是很好，自己想出来的
        ListNode temp;
        ListNode c = head;

        while (c.next != null) {
            temp = head;
            head = c.next;
            c.next = head.next;
            head.next = temp;
        }

        System.out.println("After:");
        ListNode.print(head);
        */

        // 这个是王铮的答案，感觉也更好理解一点
        // https://github.com/wangzheng0822/algo/blob/master/java/07_linkedlist/LinkedListAlgo.java
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        System.out.println("After:");
        ListNode.print(pre);
    }

    /**
     * 检测链表中是否有环
     * @param head 头结点
     * @return 是否有环
     */
    public static boolean checkCircle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 双指针检测法
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s==f) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回链表的中间结点
     *
     * @param head 头结点
     * @return 中间结点，返回第 n/2+1结点
     */
    public static ListNode getMidListNode(ListNode head) {
        // 空链表或者只有一个结点
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针方式
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        // 奇数个结点
        if (f.next == null) {
            return s;
        }

        // 偶数个结点
        return s.next;
    }

    /**
     * 删除链表倒数第 n 个结点
     *
     * @param head 头结点
     * @param n    倒数索引，必须从 1 开始
     * @return 新的头结点
     */
    public static ListNode removeNodeAtIndex(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int size = ListNode.getSize(head);
        if (n > size) {
            return head;
        }
        if (n == size) {
            head.val = 0;
            ListNode temp = head.next;
            head.next = null;
            return temp;
        } else {
            ListNode temp = head;
            int i = 0;
            while (i < (size - n - 1)) {
                i++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }

    /**
     * 合并两个有序链表
     * 时间复杂度：O(m)+O(n) 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return 合并后的头结点
     */
    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        // 此时肯定有一个链表率先到达尾结点
        pre.next = (l1 == null) ? l2 : l1;
        return preHead.next;
    }
}
