package com.advanced.advanced_class_06;

/**
 * @Descripion TODO
 * @Author Solarzhou
 * @Date 2020/6/21 19:44
 **/
public class Easy1 {
    public static int ways(int N, int curPosition, int restSteps, int K) {
        if (N < 2 || curPosition < 1 || curPosition > N || restSteps < 0 || K < 1 || K > N) {
            return 0;
        }
        if (restSteps == 0) {
            return curPosition == K ? 1 : 0;
        }
        int res = 0;
        if (curPosition == 1) {
            res = ways(N, curPosition + 1, restSteps - 1, K);
        } else if (curPosition == N) {
            res = ways(N, curPosition - 1, restSteps - 1, K);
        } else {
            res = ways(N, curPosition - 1, restSteps - 1, K) +
                    ways(N, curPosition + 1, restSteps - 1, K);
        }
        return res;
    }

    // 动态规划
    public static int dpWays(int N, int curPosition, int restSteps, int K) {
        if (N < 2 || curPosition < 1 || curPosition > N || restSteps < 0 || K < 1 || K > N) {
            return 0;
        }
        int[][] dp = new int[restSteps + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            if (i != K) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i <= restSteps; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[restSteps][curPosition];
    }

    public static int way2(int N, int curPosition, int restSteps, int K) {
        if (N < 1 || curPosition < 1 || curPosition > N || restSteps < 1 || K > N || K < 1) {
            return 0;
        }
        int res = 0;
        if (restSteps == 0) {
            res = curPosition == K ? 1 : 0;
        }
        if (restSteps == 1) {
            res = way2(N, curPosition + 1, restSteps - 1, K);
        } else if (restSteps == N) {
            res = way2(N, curPosition - 1, restSteps - 1, K);
        } else {
            res = way2(N, curPosition + 1, restSteps - 1, K) +
                    way2(N, curPosition - 1, restSteps - 1, K);
        }
        return res;
    }

    public static int dpWay2(int N, int curPosition, int restSteps, int K) {
        if (N < 1 || curPosition < 1 || curPosition > N || restSteps < 1 || K > N || K < 1) {
            return 0;
        }
        int[][] dp = new int[restSteps + 1][N + 1];
        int res = 0;
        for (int i = 0; i <= N; i++) {
            if (i != K) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i <= restSteps; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }

        return dp[restSteps][curPosition];
    }

    public static void main(String[] args) {
        System.out.println(Easy1.ways(3, 2, 3, 2));
        System.out.println(Easy1.dpWays(4, 3, 3, 3));
    }
}