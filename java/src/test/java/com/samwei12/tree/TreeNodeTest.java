package com.samwei12.tree;

import java.util.List;

import com.samwei12.leetcode.Solution104;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author xiaosen.dxs
 * @date 2020/2/15 8:01 PM
 */
public class TreeNodeTest {
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
    public void preorderTraversal() {
        List<Integer> result = TreeNode.preorderTraversal(b1);
        System.out.println(result);
    }

    @Test
    public void inorderTraversal() {
        List<Integer> result = TreeNode.inorderTraversal(b1);
        System.out.println(result);
    }

    @Test
    public void postorderTraversal() {
        List<Integer> result = TreeNode.postorderTraversal(b1);
        System.out.println(result);
    }

    @Test
    public void levelOrder() {
        List<List<Integer>> result = TreeNode.levelOrder(b1);
        System.out.println(result);
    }
}