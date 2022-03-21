package com.advanced.advanced_class_02;

import java.util.LinkedList;

/**
 * @Descripion TODO
 * 给定一个数组和滑动窗口的值，
 * 求生成窗口最大值数组
 * @Author Solarzhou
 * @Date 2020/6/13 12:20
 **/
public class getWindowMax {
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] windowMax = getWindowMax(arr, 3);
        printWindowValue(windowMax);
    }

    public static void printWindowValue(int[] arr) {
        for (Integer v :
                arr) {
            System.out.print(v + " ");
        }
    }

    public static int[] getWindowMax(int[] arr, int w) {
        if (arr == null || arr.length < 3) {
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }
}