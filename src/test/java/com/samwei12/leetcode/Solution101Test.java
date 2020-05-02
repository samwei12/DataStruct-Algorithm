package com.samwei12.leetcode;

import com.samwei12.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaosen.dxs
 * @date 2020/3/8 9:16 PM
 */
public class Solution101Test {
    TreeNode b1,b2,b3,b4,b5,b6,b7;

    @Before
    public void setUp() {
        b1 = new TreeNode(1);
        b2 = new TreeNode(2);
        b3 = new TreeNode(2);
        b4 = new TreeNode(3);
        b5 = new TreeNode(4);
        b6 = new TreeNode(4);
        b7 = new TreeNode(3);

        //b1 = new TreeNode(1);
        //b2 = new TreeNode(2);
        //b3 = new TreeNode(2);
        //b4 = null;
        //b5 = new TreeNode(3);
        //b6 = null;
        //b7 = new TreeNode(3);

        b3.left = b6;
        b3.right = b7;
        b2.left = b4;
        b2.right = b5;
        b1.left = b2;
        b1.right = b3;
    }


    @Test
    public void isSymmetric() {
        //[1,2,2,3,4,4,3] 是对称二叉树
        //assertTrue(new Solution101().isSymmetric(b1));


        //[1,2,2,null,3,null,3] 不是对称二叉树
        //assertFalse(new Solution101().isSymmetric(b1));
        System.out.println(new Solution101().isSymmetric(b1));
    }

    @Test
    public void isSymmetric2() {
        System.out.println(new Solution101().isSymmetric2(b1));
    }
}