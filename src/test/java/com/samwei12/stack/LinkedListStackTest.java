package com.samwei12.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/2 11:02 PM
 */
public class LinkedListStackTest {

    private LinkedListStack linkedListStack;

    @Before
    public void setUp() throws Exception {
        linkedListStack = new LinkedListStack();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pop() {
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println(linkedListStack);
        linkedListStack.pop();
        linkedListStack.pop();
        //linkedListStack.pop();
        System.out.println(linkedListStack);
    }

    @Test
    public void push() {
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println(linkedListStack);
    }
}