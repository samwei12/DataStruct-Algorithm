package com.samwei12.linkedlist;

/**
 * @author xiaosen.dxs
 * @date 2020/4/12 6:18 PM
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        // 末尾为 0 或者负数则直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        return solution2(x);
    }

    /**
     * 转换为字符串处理
     *
     * @param x
     * @return
     */
    public boolean solution1(int x) {
        String str = String.valueOf(x);
        String str2 = new StringBuilder(str).reverse().toString();
        return str.equals(str2);
    }

    /**
     * 倒序整数
     *
     * @param x
     * @return
     */
    public boolean solution2(int x) {
        int reverse = 0;
        // 折半比较即可
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        // 如果是偶数位数则相等，奇数位数则去除末尾位后相等
        return x == reverse || x==(reverse/10);
    }

    /**
     * 同时判定商和余数
     *
     * @param x
     * @return
     */
    public boolean solution3(int x) {
        int divisor = 1;

        // 取出最高位
        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (x > 0) {

            int left = x / divisor;

            // 跟最低位进行判断
            if (left != (x % 10)) {
                return false;
            }
            //否则，拿出中间的数字，继续进行上述操作
            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
    }
}
