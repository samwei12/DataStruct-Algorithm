package com.samwei12.sort;

import java.util.ArrayList;
import java.util.List;

public class SortTest {

    /**
     * 选择排序
     * 思想：
     * 首先，找到数组中最小的那个元素。
     * 其次，将它和数组的第一个元素交换位置。
     * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
     * 如此往复，直到将整个数组排序。
     *
     * @param input
     * @return
     */
    public static void selectSort(List<Integer> input) {
        if (input.isEmpty()) {
            return;
        }

        int count = 0;
        int exchangeCount = 0;
        for (int i = 0; i < input.size(); i++) {
            Integer min = input.get(i);
            for (int j = i + 1; j < input.size(); j++) {
                if (min > input.get(j)) {
                    int temp = input.get(j);
                    input.set(j, min);
                    min = temp;
                    input.set(i, min);
                    exchangeCount++;
                }
                count++;
            }
        }

        System.out.println("count: " + count);
        System.out.println("exchangeCount: " + exchangeCount);
    }

    /**
     * 选择排序2，加了封装
     *
     * @param input
     * @return
     */
    public static void selectSort2(List<Integer> input) {
        if (input.isEmpty()) {
            return;
        }

        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                swap(input, i, j);

                count++;
            }
        }

        System.out.println("count: " + count);
    }

    /**
     * 冒泡排序
     * 思想：
     * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。（较大的元素也会慢慢沉到底部。）
     *
     * @param input
     */
    public static void bubbleSort(List<Integer> input) {
        if (input.isEmpty()) {
            return;
        }

        int count = 0;
        int exchangeCount = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - 1 - i; j++) {
                int temp = input.get(j);
                if (input.get(j) > input.get(j + 1)) {
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                    exchangeCount++;
                }

                count++;
            }
        }
        System.out.println("count: " + count);
        System.out.println("exchangeCount: " + exchangeCount);
    }

    /**
     * 冒泡排序2, 优化版本，如果已经是有序状态，则不需要再进行排序
     *
     * @param input
     */
    public static void bubbleSort2(List<Integer> input) {
        if (input.isEmpty()) {
            return;
        }

        int count = 0;
        int exchangeCount = 0;

        // 标记是否有序
        boolean exchangeFlag = false;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size() - 1 - i; j++) {
                int temp = input.get(j);
                if (input.get(j) > input.get(j + 1)) {
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                    exchangeCount++;
                    exchangeFlag = true;
                }

                count++;
            }
            // 此次排序并无需要调整顺序的元素，表示已经处于有序状态，直接返回
            if (!exchangeFlag) {
                break;
            }
        }
        System.out.println("count: " + count);
        System.out.println("exchangeCount: " + exchangeCount);
    }

    /**
     * 插入排序
     * 思想：
     * 将第i个元素与其左边的已经有序的元素一一比较，找到合适的位置，插入其中。
     * 为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。
     *
     * @param input
     */
    public static void insertSort(List<Integer> input) {
        if (input.isEmpty()) {
            return;
        }

        int count = 0;
        int exchangeCount = 0;

        // 从 a[1] 个元素一直遍历到最右侧的元素 a[n]
        for (int i = 1; i < input.size(); i++) {

            // 从 a[i] 一直遍历左侧元素，
            for (int j = i; j > 0; j--) {

                // 如果 a[j-1] 大于 a[j]，则交换
                if (input.get(j-1) > input.get(j)) {
                    int temp = input.get(j - 1);
                    input.set(j - 1, input.get(j));
                    input.set(j, temp);

                    exchangeCount++;
                }

                count++;
            }
        }

        System.out.println("count: " + count);
        System.out.println("exchangeCount: " + exchangeCount);
    }

    /**
     * 希尔排序，对插入排序进行优化，不再是交换相邻元素，而是间隔h进行交换
     * @param input
     */
    public static void shellSort(List<Integer> input) {

    }

    /**
     * 对数组中的两个元素进行排序，小的放前面，大的放后面
     *
     * @param input
     * @param i
     * @param j
     */
    public static void swap(List<Integer> input, int i, int j) {
        int temp = input.get(i);
        if (input.get(i) > input.get(j)) {
            input.set(i, input.get(j));
            input.set(j, temp);
        }
    }

    public static void main(String[] args) {
        int[] inputs = {49, 65, 17, 66, 4, 1, 89, 61, 42, 11};
        List<Integer> input = new ArrayList<>();
        for (int i :
            inputs) {
            input.add(i);
        }

        //List<Integer> input = new ArrayList<>();
        //for (int i = 0; i < 10; i++) {
        //    input.add((new Random()).nextInt(100));
        //}

        System.out.println(input);

        // 选择排序
        //SortTest.selectSort(input);
        //SortTest.selectSort2(input);

        // 冒泡排序
        //SortTest.bubbleSort(input);
        //SortTest.bubbleSort2(input);

        // 插入排序
        //SortTest.insertSort(input);

        System.out.println(input);
    }
}
