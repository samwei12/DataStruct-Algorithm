package com.samwei12.basic;

/**
 * @author xiaosen.dxs
 * @date 2020/3/22 2:06 PM
 * 最大公约数
 */
public class MaxDivisor {
    /**
     * 辗转相减法
     *
     * @param a a int
     * @param b a int
     * @return a int
     */
    public static int method1(int a, int b) {
        if (validator(a,b) >= 0) {
            return validator(a,b);
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (true) {
            if (validator(max,min) >= 0) {
                return validator(max,min);
            }

            // 重新获取最大和最小
            int temp = max;
            max = Math.max(max, min);
            min = Math.min(temp, min);

            if (max == min) {
                return max;
            }

            max = max - min;
        }
    }

    /**
     * 辗转相除法
     *
     * @param a a int
     * @param b a int
     * @return a int
     */
    public static int method2(int a, int b) {
        if (validator(a,b) >= 0) {
            return validator(a,b);
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (true) {
            if (validator(max,min) >= 0) {
                return validator(max,min);
            }
            // 重新获取最大和最小
            int temp = max;
            max = Math.max(max, min);
            min = Math.min(temp, min);

            // 余数
            int mod = max / min;
            // 除法结果
            int value = max % min;
            if (mod == 0) {
                return min;
            }
            max = max - value * min;
        }
    }

    /**
     * 提前返回失败条件
     * @param a a int
     * @param b a int
     * @return a int
     */
    private static int validator(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a <= 0 || b <= 0) {
            return 0;
        }
        if (a == 1 || b == 1) {
            return 1;
        }
        return -1;
    }
}
