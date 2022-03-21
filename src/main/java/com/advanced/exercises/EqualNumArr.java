package com.advanced.exercises;

import java.util.LinkedList;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/22 22:18
 **/
public class EqualNumArr {
    public static int equalNumArr(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 保存 i~ j位置上的最小值元素
        LinkedList<Integer> qMin = new LinkedList<>();
        // 保存 i~ j位置上的最大值元素
        LinkedList<Integer> qMax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {

                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[j]) {
                    qMin.pollLast();
                }
                qMin.addLast(j);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[j]) {
                    qMax.pollLast();
                }
                qMax.addLast(j);
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            // 弹出过期的元素
            if (qMin.peekFirst() == i) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == i) {
                qMax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}