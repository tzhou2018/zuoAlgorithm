package com.basic;


import jdk.nashorn.internal.ir.ExpressionStatement;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_03_IPO {

    public static class Node {
        private int p;
        private int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int getMaxMoney(int K, int W, int[] costs, int[] profits) {
        if (K < 0 || W < 1 || costs == null || profits == null || costs.length != profits.length) {
            return W;
        }
        PriorityQueue<Node> costMinHeap = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> profitMaxHeap = new PriorityQueue<>(new MaxProfitComparator());
        // 所有做任务的成本压进堆
        for (int i = 0; i < costs.length; i++) {
            costMinHeap.add(new Node(profits[i], costs[i]));
        }
        for (int i = 0; i < K; i++) {
            while (!costMinHeap.isEmpty() && costMinHeap.peek().c <= W) {
                Node node = costMinHeap.poll();
                profitMaxHeap.add(node);
            }
            if (profitMaxHeap.isEmpty()) {
                return W;
            }
            W += profitMaxHeap.poll().p;
        }

        return W;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 1, 2};
        int[] arr2 = {3, 5, 3, 2};
        System.out.println(Code_03_IPO.getMaxMoney(2, 3, arr1, arr2));
    }

}
