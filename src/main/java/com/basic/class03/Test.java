package com.basic.class03;

import java.util.Stack;

/**
 * @Description TODO
 * @Author Solarhzou
 * @Date 2020/6/7 14:51
 **/
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        int uR = 0;
        int uC = 0;
        int dR = 0;
        int dC = 0;
        boolean fromUp = false;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        while (uR != endR + 1) {
            printLevel1(matrix, uR, uC, dR, dC, fromUp);
            uR = uC == endC ? uR + 1 : uR;
            uC = uC == endC ? uC : uC + 1;
            dR = dR == endR ? dR : dR + 1;
            dC = dR == endR ? dC + 1 : dC;
            fromUp = !fromUp;
        }
    }

    public static void printLevel1(int[][] m, int uR, int uC, int dR, int dC, boolean fromUp) {
        if (fromUp) {
            while (uR != dR + 1) {
                System.out.print(m[uR++][uC--] + " ");
            }
        } else {
            while (dR != uR - 1) {
                System.out.print(m[dR--][dC++] + " ");
//                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static class Mystack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Mystack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public int getMin() {
            return stackMin.peek();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= getMin()) {
                stackMin.push(newNum);
            } else {
                stackMin.push(getMin());
            }
            stackData.push(newNum);
        }

        public int pop() {
            stackMin.pop();
            return stackData.pop();
        }
    }


}
