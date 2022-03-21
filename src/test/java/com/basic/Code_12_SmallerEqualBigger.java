package com.basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description TODO
 * @Author Solarhzou
 * @Date 2020/5/31 11:05
 **/
public class Code_12_SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public static Node listPartition1(Node head, int pivot) {
            if (head == null) {
                return null;
            }
            ArrayList<Node> nodes = new ArrayList<>();
            Node cur = head;
            while (cur != null) {
                nodes.add(cur);
                cur = cur.next;
            }
            // 同荷兰国旗问题，对所给数组进行排序
            partition(nodes, pivot);
            for (int i = 1; i < nodes.size(); i++) {
                nodes.get(i - 1).next = nodes.get(i);
            }
            nodes.get(nodes.size() - 1).next = null;
            return nodes.get(0);
        }

        public static void partition(ArrayList<Node> nodes, int pivot) {
            int small = -1;
            int big = nodes.size();
            int index = 0;
            while (index < big) {
                if (nodes.get(index).value < pivot) {
                    small++;
                    Collections.swap(nodes, small, index);
                    index++;
                } else if (nodes.get(index).value > pivot) {
                    big--;
                    Collections.swap(nodes, index, big);
                } else {
                    index++;
                }
            }
        }

        // 方法2 保证稳定性
        public static Node listPartition2(Node head, int pivot) {
            Node sH = null; // small head
            Node sT = null; // small tail
            Node eH = null; // equal head
            Node eT = null; // equal tail
            Node bH = null; // big head
            Node bT = null; // big tail
            Node next = null; // save next node
            while (head != null) {
                next = head.next;
                head.next = null;
                if (head.value < pivot) {
                    if (sH == null) {
                        sH = head;
                        sT = head;
                    } else {
                        sT.next = head;
                        sT = head;
                    }
                } else if (head.value > pivot) {
                    if (eH == null) {
                        eH = head;
                    } else {
                        eT.next = head;
                    }
                    eT = head;
                } else {
                    if (bH == null) {
                        bH = head;
                    } else {
                        bT.next = head;
                    }
                    bT = head;
                }
                head = next;
            }
            // 将三个链表穿起来
            if (sT != null) {
                sT.next = eH;
                eT = eT == null ? sT : eT;
            }
            // all reconnect
            if (eT != null) {
                eT.next = bH;
            }
            return sH != null ? sH : eH != null ? eH : bH;
        }

        public static void printLinkedList(Node node) {
            System.out.print("Linked List: ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Node head1 = new Node(7);
            head1.next = new Node(9);
            head1.next.next = new Node(1);
            head1.next.next.next = new Node(8);
            head1.next.next.next.next = new Node(5);
            head1.next.next.next.next.next = new Node(2);
            head1.next.next.next.next.next.next = new Node(5);
            printLinkedList(head1);
            head1 = listPartition1(head1, 4);
            printLinkedList(head1);
        }
    }
}
