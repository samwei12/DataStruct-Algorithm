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
        int low = start+1;
        int high = end;
        while (low<high) {

            // 1. 从右侧向左侧遍历，直到出现小于锚点的元素
            while (array[high] >= guard) {
                high--;
            }
            swap(array, high, low);

            // 2. 从左侧向右侧遍历，直到出现大于锚点的元素
            while (array[low] <= guard) {
                low++;
            }
            swap(array, high, low);
        }

        // 交换首元素和低位元素，准备下一次交换
        if (array[low]>guard) {
            swap(array, start, low);
        }

        // 一次比较完成，之后对这次结果的两侧数组分别进行排序
        sort(array, start, low);
        sort(array, high, end);
    }

    static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] =  temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(89)+10;
        }
        System.out.println(Arrays.toString(arr));
        QuickSort.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
