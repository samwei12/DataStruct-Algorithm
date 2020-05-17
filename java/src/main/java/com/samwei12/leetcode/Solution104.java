package com.samwei12.leetcode;

import com.samwei12.tree.TreeNode;

/**
 * @author xiaosen.dxs
 * @date 2020/3/8 9:00 PM
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution104 {

    /**
     * @param root root node
     * @return depth
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }

    /**
     * 使用前序遍历返回二叉树的深度，目前看起来好像入参没有层级信息的话，无法使用前序遍历，只能使用后序遍历
     *
     * @param root 二叉树的根节点
     * @return 二叉树的深度
     */
    public static int maxDepth(TreeNode root, int depth) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        // 叶子节点
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        if (root.left != null) {
            maxDepth = maxDepth(root.left, depth+1);
        }
        if (root.right != null) {
            maxDepth = maxDepth(root.right, depth+1);
        }
        return maxDepth;
    }
}
