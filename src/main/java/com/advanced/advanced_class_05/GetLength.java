package com.advanced.advanced_class_05;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/22 16:07
 **/
public class GetLength {
    public static int getLength(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int max = Integer.MIN_VALUE;
        while (right < arr.length) {
            if (sum == k) {
                max = Math.max(max, right - left + 1);
                sum = sum - arr[left++];
            }
            if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return max;
    }
}