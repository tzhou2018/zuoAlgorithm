package com.advanced.exercises;

import java.util.LinkedList;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/22 21:47
 **/
public class GetWindowMax {
    public static int[] getWindowMax(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        // 定义双端队列，保存窗口中的最大值
        LinkedList<Integer> qMax = new LinkedList<>();
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


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5};
        int[] windowMax = getWindowMax(arr, 3);
        for (Integer v :
                windowMax) {
            System.out.print(v + " ");
        }
    }
}