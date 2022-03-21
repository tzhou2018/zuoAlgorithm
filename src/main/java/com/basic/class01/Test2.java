package com.basic.class01;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * @Description TODO
 * 递归求最大值
 * @Author Solarhzou
 * @Date 2020/5/27 21:51
 **/
public class Test2 {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxLeft = getMax(arr, L, mid);
        int maxRight = getMax(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);
//        return 0;
    }

    public static int test1(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
//                x++;
                continue;
            } else {
                int temp = arr[i];
                arr[i] = arr[++x];
                arr[x] = temp;
            }
        }
        return x + 1;
    }

    // 改进后的快排
//    public static void quickSort(int[] arr, int lo, int hi) {
//        if (lo < hi) {
//
//            int[] p = partition(arr, lo, hi);
//            quickSort(arr, lo, p[0] - 1);
//            quickSort(arr, p[1] + 1, hi);
//        }
//
//    }
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
//            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            swap(arr, (int) (l + Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int lo, int hi) {

        int less = lo - 1;
        int more = hi;
        while (lo < more) {
            if (arr[lo] < arr[hi]) {
                swap(arr, ++less, lo++);
            } else if (arr[lo] > arr[hi]) {
                swap(arr, --more, lo);
            } else {
                lo++;
            }
        }
        swap(arr, more, hi);
        return new int[]{less + 1, more};
    }

    //-----------
    // 改进后的快排
    public static int[] partition2(int[] arr, int lo, int hi) {
        int less = lo - 1;
        int more = hi;
        while (lo < more) {
            if (arr[lo] < arr[hi]) {
                swap(arr, ++less, lo++);
            } else if (arr[lo] > arr[hi]) {
                swap(arr, --more, lo);
            } else {
                lo++;
            }
        }
        swap(arr, more, hi);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] arr, int index) {
//        int parent = (index - 1) / 2;
//        while (arr[index] > arr[parent]) {
//            swap(arr, index, parent);
//            index = parent;
//            parent = (index - 1) / 2;
//        }
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 荷兰国旗问题
    public static void sortColor(int[] arr, int lo, int hi) {
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
    }

    public static void main(String[] args) {
        int[] ints = {1, 5, 1, 4, 2, 3};
//        int[] arrColor = {1, 1, 1, 2, 0, 1, 2, 2, 0};
        int[] arrColor = {0, 0, 1, 1, 2, 1, 0, 1};
//        System.out.println(getMax(ints, 0, ints.length - 1));
//        System.out.println(test1(ints, 3));
        quickSort(ints, 0, ints.length - 1);
//        heapSort(ints);
        for (Integer v :
                ints) {
            System.out.print(v + " ");
        }
        System.out.println();
        sortColor(arrColor, 0, arrColor.length);
        for (Integer v :
                arrColor) {
            System.out.print(v + " ");
        }
    }
}
