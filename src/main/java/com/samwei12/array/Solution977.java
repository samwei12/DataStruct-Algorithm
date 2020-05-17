package com.samwei12.array;

import java.util.Arrays;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/17 5:35 PM
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return method1(A);
    }

    /**
     * 暴力解法
     * 1. 遍历取出所有数字，然后平方并插入一个新的数组
     * 2. 对新的数组进行排序
     * @param A
     * @return
     */
    private int[] method1(int[] A) {
        int[] squares = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            squares[i] = A[i] * A[i];
        }
        Arrays.sort(squares);
        return squares;
    }
}
