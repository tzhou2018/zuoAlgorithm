package com.basic.class04;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_07_IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 中序序遍历记录每个节点的值，非递减即满足条件
    // 这种方法比较繁琐,可以参考中序遍历方法
    // src\main\java\com\basic\class04\Code_01_PreInPosTraversal.java
    public static boolean isBST1(Node head) {
        if (head == null) {
            return false;
        }
        int leftMostValue = findLeftMost(head).value;
        boolean flag = true;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
//                flag = head.value >= leftMostValue ? true : false;
                if (head.value >= leftMostValue) {
                    leftMostValue = head.value;
                } else {
                    return false;
                }
//                System.out.println(head.value + " ");
                head = head.right;
            }
        }
        return true;
    }

    public static Node findLeftMost(Node head) {
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    // 下面这种方法比较繁琐,可以参考中序遍历方法
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node l;
        Node r;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            // 如果 node 左结点为空，右节点不为空，返回 false；
            // 开启叶子结点判断时，若是 node 左节点或右节点有一个不为空则返回false；
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
//            if (l != null) {
//                queue.offer(l);
//            }
//            if (r != null) {
//                queue.offer(r);
//            }
//            if (l == null || r == null) {
//                leaf = true;
//            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node left = node.left;
            Node right = node.left;
            if ((left == null && right != null) || (leaf && (left != null || right != null))) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));
        System.out.println(isBST1(head));

    }
}