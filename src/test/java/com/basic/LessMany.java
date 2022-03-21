package com.basic;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import jdk.nashorn.internal.ir.CallNode;

import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author Solarhzou
 * @Date 2020/5/31 15:22
 **/
public class LessMany {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = null;
        String str3 = "abcdefg";
        char[] chars = {'a', 'b', 'c'};
        System.out.println(String.valueOf(chars));
        System.out.println(str3.substring(1, 3));
        int[] ints = {10, 20, 30};
        System.out.println(lessMany(ints));
    }

    public static int lessMany(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int res = 0;
        int cur = 0;
        while (heap.size() > 1) {
            cur = heap.poll() + heap.poll();
            res += cur;
            heap.add(cur);
        }
        return res;
    }
}
