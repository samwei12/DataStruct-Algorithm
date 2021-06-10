package com.samwei12.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/8/21 7:13 PM
 */
public class QuickSort {
    static void sort(int[] array, int start, int end) {
        if (array == null || array.length < end + 1 || start < 0 || end <= start) {
            return;
        }


        int guard = array[start];
        int low = start;
        int high = end + 1;
        while (true) {
//            从左侧向右侧遍历，直到出现大于锚点的元素
            while (low < end && array[++low] <= guard) {

            }
//            从右侧向左侧遍历，直到出现小于锚点的元素
            while (high > start && array[--high] >= guard) {

            }
//            high 小于锚点元素，交换 high 跟 low
            if (low < high) {
                swap(array, low, high);
            }
//            否则，代表当前这次已经排序完成，左边都是小于等于锚点；右边都是大于等于锚点
            else {
                break;
            }
        }

        // 交换首元素和高位元素，准备下一次交换
        swap(array, start, high);

        // 一次比较完成，之后对这次结果的两侧数组分别进行排序
        sort(array, start, high - 1);
        sort(array, high + 1, end);
    }

    static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] =  temp;
    }

    public static void main(String[] args) {
//        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(89)+10;
        }
        System.out.println(Arrays.toString(arr));
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
