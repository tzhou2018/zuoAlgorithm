package com.basic.class08;

public class Test {

    public static int f(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return f(N - 1) + f(N - 2);
    }

    public static boolean isSum(int[] arr, int i, int sum, int aim) {
        if (i == arr.length) {
            return true;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int aim = 7;
        System.out.println(isSum(arr, 0, 0, aim));
    }

}
