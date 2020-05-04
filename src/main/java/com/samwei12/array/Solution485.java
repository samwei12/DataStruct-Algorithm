package com.samwei12.array;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/4 3:00 PM
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class Solution485 {

    /**
     * https://leetcode-cn.com/problems/max-consecutive-ones/
     * 给定一个二进制数组，返回最长的连续 1 的个数
     * Input: [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     *
     * @param nums 二进制数组，只有 0，1
     * @return 最长的连续 1 的个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }
        return method2(nums);
    }

    /**
     * 常规解法，思路：直接进行遍历，
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums 二进制数组，只有 0，1
     * @return 最长的连续 1 的个数
     */
    private int method1(int[] nums) {
        int count = 0;
        int maxConsecutive = count;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, count);
                count = 0;
            }
        }
        maxConsecutive = Math.max(maxConsecutive, count);
        return maxConsecutive;
    }

    /**
     * 滑动窗口法，思路
     * https://leetcode-cn.com/problems/max-consecutive-ones/solution/java-485-zui-da-lian-xu-1de-ge-shu-hua-dong
     * -chuang/
     *
     * @param nums 二进制数组，只有 0，1
     * @return 最长的连续 1 的个数
     */
    private int method2(int[] nums) {
        int maxConsecutive = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right++] == 0) {
                maxConsecutive = Math.max(right - left - 1, maxConsecutive);
                left = right;
            }
        }
        maxConsecutive = Math.max(right - left, maxConsecutive);
        return maxConsecutive;
    }
}
