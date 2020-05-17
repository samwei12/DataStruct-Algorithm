package com.samwei12.leetcode;

import com.samwei12.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/3/8 9:16 PM
 */
public class Solution104Test {

    TreeNode b1,b2,b3,b4,b5,b6,b7;

    @Before
    public void setUp() {
        b1 = new TreeNode(1);
        b2 = new TreeNode(2);
        b3 = new TreeNode(3);
        b4 = new TreeNode(4);
        b5 = new TreeNode(5);
        b6 = new TreeNode(6);
        b7 = new TreeNode(7);

        b3.left = b6;
        b3.right = b7;
        b2.left = b4;
        b2.right = b5;
        b1.left = b2;
        b1.right = b3;
    }

    @Test
    public void maxDepth() {
        System.out.println(Solution104.maxDepth(b1, 1));
    }

    @Test
    public void maxDepth2() {
        System.out.println(Solution104.maxDepth(b1));
    }
}