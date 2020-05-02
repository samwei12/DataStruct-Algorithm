package com.samwei12.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.samwei12.tree.TreeNode;

/**
 * @author xiaosen.dxs
 * @date 2020/3/8 8:48 PM
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 分析思路：
 * 1. 我们先要明确使用前序遍历还是后序遍历
 * 2. 首先需要明确的点是，什么情况下才算是对称？给定一个节点，如果：
 *      1. 当他的左右都是 null，显然是对称， true
 *      2. 当他的左右节点其中一个为 null，一个不为 null， false
 *      3. 当他的左右都不是 null，需要判断它的左右子节点分别是否对称，这里又需要满足两个条件（**递归条件出现了**）
 *          1. 左右子节点的值相同
 *          2. 左子树的左节点与右子树的右节点对称，左子树的右节点与右子树的左节点对称
 * 3. 所以这里我们需要两个方法，一个是真正判断对称的，需要两个入参，分别是一个节点的两个子节点
 */
public class Solution101 {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // 1. 根节点为空直接返回 true
        if (root == null) {
            return true;
        }

        // 2. 判断左右子树是否对称
        return isSymmetric(root.left, root.right);
    }

    /**
     * 检查给定同一个节点的两个子节点是否对称
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // 同时为 null 返回 true
        if (left== null && right == null) {
            return true;
        }

        // 左右子节点不同时为 null 时返回 false
        if (left==null || right == null) {
            return false;
        }

        // 左右节点都有值，比较左子树和右子树是否对称
        boolean res1 = isSymmetric(left.left, right.right);
        boolean res2 = isSymmetric(left.right, right.left);
        return res1 && res2 && (left.val == right.val);
    }

    /**
     * 使用层序遍历
     *      1. 根节点非空则入队列
     *      2. 队列非空的情况下循环
     *      3. 循环体：
     *          1. 当前节点出列
     *          2. 左节点入队列
     *          3. 右节点入队列
     *          4. 迭代节点个数次
     *          5. 每一层结束判断
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        // 1. 根节点为空直接返回 true
        if (root == null) {
            return true;
        }

        // 根节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            // 当前层级
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                // 出队
                TreeNode node = queue.poll();
                if (node==null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            boolean allNull = true;
            // 迭代当前层级所有节点
            for (int i = 0; i < queue.size()/2; i++) {
                TreeNode left = (TreeNode)((LinkedList)queue).get(i);
                TreeNode right = (TreeNode)((LinkedList)queue).get(queue.size()-i-1);
                // 均不为 null
                if (left!=null && right != null) {
                    // 如果值不相等，则直接返回 false
                    if (left.val != right.val) {
                        return false;
                    }
                    // 值也相同，则将全空标记置为 false
                    allNull = false;
                }
                // 其中一个子节点为 null，返回 false
                if (left!=null && right == null) {
                    return false;
                }
                if (right!=null && left == null) {
                    return false;
                }

                // 两个节点都为空，则继续迭代
            }
            // 所有节点都为空，此时如果还没有返回 false，则代表对称
            if (allNull) {
                return true;
            }
        }
    }
}
