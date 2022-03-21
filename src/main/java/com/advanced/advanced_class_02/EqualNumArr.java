package com.advanced.advanced_class_02;

import java.util.LinkedList;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/13 12:51
 **/
public class EqualNumArr {
    public static int numArr(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int L = 0;
        int R = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    break;
                }
                R++;
            }
            if (qMin.peekFirst() == L) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == R) {
                qMax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1,};
        int num = 2;
        System.out.println(numArr(arr, num));
    }
}