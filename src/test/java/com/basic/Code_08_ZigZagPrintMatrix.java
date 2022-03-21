package com.basic;

/**
 * @Description TODO
 * @Author Solarhzou
 * @Date 2020/6/7 14:22
 **/
public class Code_08_ZigZagPrintMatrix {
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
            printLevel(matrix, uR, uC, dR, dC, fromUp);
            uR = uC == endC ? uR + 1 : uR;

            uC = uC == endC ? uC : uC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
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
}
