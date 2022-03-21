package com.basic.class07;

import java.util.Arrays;
import java.util.Comparator;

public class Code_06_BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 按照结束时间进行排序
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }

    }

    public static int bestArrange(int[] startM, int[] endM, int start) {

        Program[] programs = new Program[startM.length];
        for (int i = 0; i < startM.length; i++) {
            programs[i] = new Program(startM[i], endM[i]);
        }
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] starts = {3, 3, 3, 5, 7};
        int[] ends = {4, 5, 4, 6, 8};
        System.out.println(bestArrange(starts, ends, 1));
    }

}
