package com.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author xhwangg@foxmail.com
 * @create 2020-08-20-20:55
 */
public class Shunfeng2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a =scanner.nextInt();
        long[][] arr=new long[(int) a][3];
        for (int i = 0; i < a; i++) {
            arr[i][0]=scanner.nextLong();
            arr[i][1]=scanner.nextLong();
            arr[i][2]=scanner.nextLong();
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[1]-o2[1]);
            }
        });
        /**
         * 动态规划，dp记录做完当前任务可获得的最大收益
         */
        long[] dp=new long[(int) a];
        dp[0]=arr[0][2];
        for (int i = 1; i < a; i++) {
            int begin=0;
            while (arr[begin][1]<arr[i][0]){
                begin++;
            }
            long tmp=0;
            if (begin>=1){
                tmp=dp[begin-1]+arr[i][2];
            }else {
                tmp=arr[i][2];
            }
            dp[i]=Math.max(tmp,dp[i-1]);
        }
        System.out.println(dp[a-1]);
    }

}