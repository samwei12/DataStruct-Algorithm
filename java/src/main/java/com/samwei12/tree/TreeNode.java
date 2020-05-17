package com.samwei12.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaosen.dxs
 * @date 2020/2/15 7:40 PM
 * 这个其实是一个二叉树节点，因为 LeetCode 直接叫这个名字，所以使用这个名字，而不是使用 BinaryTreeNode
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }

    /**
     * 前序遍历
     *      1. 判断当前节点是否为空
     *      2. 把当前节点添加到结果中
     *      3. 遍历当前节点的左子树并返回集合结果
     *      4. 遍历当前节点的右子树并返回集合结果
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 先添加根节点
        result.add(root.val);

        // 判断是否有左子树
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }

        return result;
    }

    /**
     * 中序遍历
     *      1. 判断当前节点是否为空
     *      2. 遍历当前节点的左子树并返回集合结果
     *      3. 把当前节点添加到结果中
     *      4. 遍历当前节点的右子树并返回集合结果
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 判断是否有左子树
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }

        // 先添加根节点
        result.add(root.val);

        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }

    /**
     * 后序遍历
     *      1. 判断当前节点是否为空
     *      2. 遍历当前节点的左子树并返回集合结果
     *      3. 遍历当前节点的右子树并返回集合结果
     *      4. 把当前节点添加到结果中
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 判断是否有左子树
        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            result.addAll(postorderTraversal(root.right));
        }

        // 先添加根节点
        result.add(root.val);

        return result;
    }

    /**
     * 层次遍历：
     *      1. 根节点非空则入队列
     *      2. 队列非空的情况下循环
     *      3. 循环体：
     *          1. 当前节点出列
     *          2. 左节点入队列
     *          3. 右节点入队列
     *          4. 迭代节点个数次
     *          5. 每一层结束将结果存上
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 根节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 循环
        while (!queue.isEmpty()) {
            // 当前遍历深度的总节点个数
            int count = queue.size();

            List<Integer> levelResult = new ArrayList<>();

            // 遍历该层每个节点
            for (int i = 0; i < count; i++) {
                // 当前节点出队
                TreeNode node = queue.poll();
                if (node != null) {
                    // 将该节点的叶子节点入队
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    levelResult.add(node.val);
                }
            }

            result.add(levelResult);
        }

        return result;
    }
}
