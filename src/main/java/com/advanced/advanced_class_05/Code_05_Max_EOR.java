package com.advanced.advanced_class_05;

public class Code_05_Max_EOR {
    // 解法1
    // 暴力求解
    public static int getMaxE1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int start = 0; start <= i; start++) {
                int res = 0;
                for (int k = start; k <= i; k++) {
                    res ^= arr[k];
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    // 解法2
    // O(n2)  用空间换取时间
    // 将每次的异或结果记录下来
    public static int getMax2(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;
        int eof = 0;
        for (int i = 0; i < arr.length; i++) {
            eof ^= arr[i];
            max = Math.max(max, eof);
            for (int start = 1; start <= i; i++) {
                int curEof = eof ^ dp[start - 1];
                max = Math.max(max, curEof);
            }
            dp[i] = eof;
        }
        return max;
    }

    //---------------
    public static int getMax3(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;
        int eof = 0;
        for (int i = 0; i < arr.length; i++) {
            eof ^= arr[i];
            max = Math.max(max, eof);
            for (int start = 1; start <= i; start++) {
                int curEof = eof ^ dp[start - 1];
                max = Math.max(curEof, max);
            }
            dp[i] = eof;
        }
        return max;
    }

    // 前缀树
    public static class Node {
        public Node[] nexts = new Node[2];
    }

    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = ((num >> move) & 1);
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        // num 0 ~ i 的异或结果
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                int best = move == 31 ? path : (path ^ 1); // 期待要选的路
                best = cur.nexts[best] != null ? best : (best ^ 1); // 实际走的路
                res |= (path ^ best) << move;   // 设置答案的每一位
                cur = cur.nexts[best];          // 继续往下走
            }
            return res;
        }

    }


    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
