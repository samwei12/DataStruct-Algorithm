package com.samwei12.stack;

import java.util.LinkedList;

import com.samwei12.linkedlist.ListNode;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/2 10:35 PM
 */
public class LinkedListStack{
    private ListNode top;

    public LinkedListStack() {
        this.top = null;
    }

    /**
     * 弹出栈顶元素
     * @return -1 表示已经是空栈
     */
    public int pop() {
        ListNode result = top;
        if (top == null) {
            return -1;
        }
        top = top.getNext();
        return result.getVal();
    }

    /**
     * 将元素压入栈顶
     * @param item 元素
     * @return 始终为 true
     */
    public Boolean push(int item) {
        ListNode newNode = new ListNode(item);
        // 空栈
        if (top == null) {
            top = newNode;
        }
        else {
            newNode.setNext(top);
            top = newNode;
        }
        return true;
    }

    @Override
    public String toString() {
        ListNode.print(top);
        return "LinkedListStack{}";
    }
}
