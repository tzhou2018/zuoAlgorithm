package com.advanced.advanced_class_05;

import com.sun.org.apache.regexp.internal.RE;

import java.util.List;


public class Code_04_MaxHappy {
    public static class Node {
        public int huo;
        public List<Node> nexts;

        public Node(int huo, List<Node> nexts) {
            this.huo = huo;
            this.nexts = nexts;
        }
    }

    public static class ReturnNode {
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnNode(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }

    public static ReturnNode process(Node head) {
        if (head == null) {
            return new ReturnNode(0, 0);
        }
        int lai_huo = head.huo;
        int bu_lai_huo = 0;
        for (int i = 0; i < head.nexts.size(); i++) {
            Node node = head.nexts.get(i);
            ReturnNode returnData = process(node);
            lai_huo += returnData.bu_lai_huo;
            bu_lai_huo += Math.max(returnData.lai_huo, returnData.bu_lai_huo);
        }
        return new ReturnNode(lai_huo, bu_lai_huo);
    }

    // 利用同样的讨论解决平衡二叉树问题
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static class ReturnTreeNode {
        public boolean isB;
        public int h;

        public ReturnTreeNode(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static ReturnTreeNode isBBT(TreeNode head) {
        if (head == null) {
            return new ReturnTreeNode(true, 0);
        }
        ReturnTreeNode left = isBBT(head.left);
        if (left.isB == false) {
            return new ReturnTreeNode(false, left.h + 1);
        }
        ReturnTreeNode right = isBBT(head.right);
        if (!right.isB) {
            return new ReturnTreeNode(false, right.h + 1);
        }
        if (Math.abs(left.h - right.h) > 1) {
            return new ReturnTreeNode(false, Math.max(left.h, right.h));
        }
        return new ReturnTreeNode(true, Math.max(left.h, right.h));
    }
    ////////////////////
    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 8}, {1, 9}, {1, 10}};
        System.out.println(maxHappy(matrix));
    }
}
