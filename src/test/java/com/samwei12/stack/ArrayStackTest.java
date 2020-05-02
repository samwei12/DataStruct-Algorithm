package com.samwei12.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/2 10:42 PM
 */
public class ArrayStackTest {

    private ArrayStack<String> stringArrayStack;

    @Before
    public void setUp() throws Exception {
        stringArrayStack = new ArrayStack<>(5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pop() {
        stringArrayStack.push("1");
        stringArrayStack.push("hello");
        stringArrayStack.push("test");
        stringArrayStack.push("world");
        stringArrayStack.push("3");
        stringArrayStack.push("null");
        System.out.println(stringArrayStack);
        stringArrayStack.pop();
        stringArrayStack.pop();
        System.out.println(stringArrayStack);
    }

    @Test
    public void push() {
        stringArrayStack.push("1");
        stringArrayStack.push("hello");
        stringArrayStack.push("3");
        System.out.println(stringArrayStack);
    }
}