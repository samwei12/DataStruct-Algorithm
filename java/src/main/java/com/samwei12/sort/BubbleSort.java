package com.samwei12.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xiaosen.dxs@alibaba-inc.com
 * @date 2020/8/21 5:22 PM
 */
public class BubbleSort {
    static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(89)+10;
        }
        System.out.println(Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
