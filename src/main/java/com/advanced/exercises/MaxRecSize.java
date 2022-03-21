package com.advanced.exercises;

import java.util.Stack;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/22 22:56
 **/
public class MaxRecSize {
    public static int maxRecSize(int[][] arr) {
        if (arr == null || arr[0].length == 0 || arr.length == 0) {
            return 0;
        }
        int[] res = new int[arr[0].length];
        for (int col = 0; col < arr[0].length; col++) {
            res[col] = arr[0][col];
        }
        for (int row = 1; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == 0) {
                    res[col] = 0;
                } else
                    res[col] += arr[row][col];
//                res[col] += arr[row][col] == 0 ? 0 : arr[row][col];
            }
        }
        return maxRecFromBottom(res);
    }

    public static int maxRecFromBottom(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                // 清算当前弹出元素
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : (stack.peek());
                maxArea = Math.max(maxArea, (i - k - 1) * arr[j]);
            }
            stack.push(i);
        }
        // 清算剩余元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (arr.length - k - 1) * arr[j]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0};
        int[][] arrD = {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        System.out.println(maxRecFromBottom(arr));
        System.out.println(maxRecSize(arrD));
    }
}