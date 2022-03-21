package com.basic;


import java.util.Scanner;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/7/4 22:08
 **/
public class Test01 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int numsLen = nums.length;
        int sum = 0;
        for (int i = 0; i < numsLen; i++) {
            sum += nums[i];
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[numsLen][target + 1];
        for (int i = 0; i <= target; i++) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < numsLen; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == nums[i]) {
                    dp[i][j] = true;
                    continue;
                }
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        for (int i = 0; i < numsLen; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[numsLen - 1][target];
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int[] arr = {1, 5, 5, 11};
        System.out.println(test01.canPartition(arr));

    }
}
