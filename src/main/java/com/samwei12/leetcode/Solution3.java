package com.samwei12.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaosen.dxs
 * @date 2020/3/5 2:27 PM
 */
public class Solution3 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     * s.length <= 40000
     * Demo1:
     *   输入: "abcabcbb"
     *   输出: 3
     *   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s s.length <= 40000
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() ==0 || s.length()==1){
            return s.length();
        }

        int res = 0;
        // 解法一：粗暴遍历
        //for (int j = 0; j < s.length() - 1; j++) {
        //    StringBuilder subString = new StringBuilder();
        //    for (int i = j; i < s.length(); i++) {
        //        final char c = s.charAt(i);
        //        if (subString.indexOf(String.valueOf(c))!=-1) {
        //            break;
        //        } else {
        //            subString.append(c);
        //        }
        //      res = Math.max(res, subString.size());
        //    }
        //}

        // 解法二：滑动窗口法
        // 窗口头部索引
        int head = 0;
        // 窗口尾部索引
        int tail = head;
        //StringBuilder subString = new StringBuilder(s.substring(head,tail));
        //while (tail<s.length()) {
        //    final String s1 = s.substring(tail, tail + 1);
        //    if (subString.indexOf(s1) != -1) {
        //        head++;
        //        //tail=head;
        //        subString = new StringBuilder(s.substring(head,tail));
        //    } else {
        //        subString.append(s1);
        //        tail++;
        //    }
        //
        //      res = Math.max(res, subString.size());
        //}

        //滑动窗口解法二，使用 HashSet
        Set<Character> subString = new HashSet<>();
        while (tail<s.length()) {
            final char c = s.charAt(tail);
            // 有重复字符
            while (subString.contains(c)) {
                subString.remove(s.charAt(head));
                head++;
            }
            subString.add(c);
            tail++;

            res = Math.max(res, subString.size());
        }

        return res;
    }
}
