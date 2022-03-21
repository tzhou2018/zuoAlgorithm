package com.exam;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author xhwangg@foxmail.com
 * @create 2020-08-20-20:14
 */
public class ShunFeng1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][] arr2 = new int[b][2];
        for (int i = 0; i < b; i++) {
            arr2[i][0] = scanner.nextInt();
            arr2[i][1] = scanner.nextInt();
        }
        int res = dp(arr, arr2);
        System.out.println(res);
    }

    private static int dp(int[] a, int[][] b) {
        Arrays.sort(a);
        Arrays.sort(b, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        int res = 0;
        boolean[] arr = new boolean[b.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = 0;
            int bi = -1;
            for (int j = 0; j < b.length; j++) {
                if (!arr[j] && b[j][0] <= a[i]) {
                    if (b[j][1] > tmp) {
                        bi = j;
                        tmp = b[j][1];
                    }
                }
            }
            if (bi >= 0) {
                arr[bi] = true;
            }
            res += tmp;
        }
        return res;
    }

}