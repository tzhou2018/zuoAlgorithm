package com.leetcode.one2twenty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2022/3/21 21:48
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 4};
        int target = 6;
//        System.out.println(twoSum(arr, target).toString());
        print(twoSum(arr, target));
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static void print(int[] arr) {
        for (Integer e :
                arr) {
            System.out.printf("%d\\t", e);
            ;
        }
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        if (arr.length < 2 || arr == null) {
            return null;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (hashTable.containsKey(target - arr[i])) {
                    return new int[]{hashTable.get(target - arr[i]), i};
                }
                hashTable.put(arr[i], i);
            }
        }
        return new int[0];
    }
}