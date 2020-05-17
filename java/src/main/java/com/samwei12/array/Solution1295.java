package com.samwei12.array;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/5/4 4:02 PM
 */
public class Solution1295 {
    /**
     * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     * 限制条件：
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     * @param nums 整数数组
     * @return 结果
     */
    public int findNumbers(int[] nums) {
        if (nums == null) {
            return 0;
        }
        return method3(nums);
    }

    /**
     * 常规解法
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * @param nums 整数数组
     * @return 结果
     */
    private int method1(int[] nums) {
        int result = 0;
        for (int i : nums) {
            if (calculateDigits(i) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 解法二：转换为字符串，然后直接读取字符串长度
     * 时间复杂度：O(n*n) 因为将数字转换为字符串复杂度不是 O(1)
     * @param nums 整数数组
     * @return 结果
     */
    private int method2(int[] nums) {
        int result = 0;
        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 解法三：直接使用 log10 方法
     * @param nums 整数数组
     * @return 结果
     */
    private int method3(int[] nums) {
        int result = 0;
        for (int i : nums) {
            if (((int)Math.log10(i)+1) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 计算指定整数的位数
     * @param num 整数
     * @return 位数
     */
    public static int calculateDigits(int num) {
        int digit = 0;
        if (num == 0) {
            return 1;
        }
        while (num > 0) {
            num = num / 10;
            digit ++;
        }
        return digit;
    }
}
