package com.basic.class01;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2022/3/22 23:21
 **/
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i]++;
            System.out.println(a);
            System.out.println("arr" + arr[i]);
//            System.out.println(arr[i]++);
        }
    }
}