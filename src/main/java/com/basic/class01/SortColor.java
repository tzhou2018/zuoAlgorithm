package com.basic.class01;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/23 21:18
 **/
public class SortColor {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 1, 0, 1};
        int[] res = sortColor(arr, 0, arr.length);
        for (Integer v :
                res) {
            System.out.print(v + " ");
        }
    }

    public static int[] sortColor(int[] arr, int lo, int hi) {
        if (arr == null || arr.length == 1) {
            return null;
        }
        int less = lo - 1;
        int most = hi;
        while (lo < most) {
            if (arr[lo] == 0) {
                swap(arr, ++less, lo++);
            } else if (arr[lo] == 2) {
                swap(arr, --most, lo);
            } else {
                lo++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}