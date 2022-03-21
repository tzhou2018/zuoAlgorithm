package com.basic.class04;

public class Code_06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    // -----------
    // 重写
    public static class ReturnType {
        private boolean isB;
        private int h;

        public ReturnType(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static ReturnType isBBT(Node head, int h) {
        if (head == null) {
            return new ReturnType(true, h);
        }
        ReturnType left = isBBT(head.left, h + 1);
        if (!left.isB) {
            return new ReturnType(false, h);
        }
        ReturnType right = isBBT(head.right, h + 1);
        if (!right.isB) {
            return new ReturnType(false, h);
        }
        if (Math.abs(left.h - right.h) > 1) {
            return new ReturnType(false, Math.max(left.h, right.h));
        }
        return new ReturnType(true, Math.max(left.h, right.h));
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
        System.out.println(isBBT(head, 0).h);

    }

}
