package com.basic;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Solarhzou
 * @Date 2020/5/30 9:16
 **/
public class MaxGap {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 10};
        System.out.println(maxGap(arr));
    }


    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int bid = bucket(nums[i], min, max, len);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int lastMax = maxs[0];
        int res = 0;
        for (int i = 1; i < len + 1; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, int min, int max, int len) {
        return (int) ((num - min) * len / (max - min));
    }

    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            this.queue = new LinkedList();
            this.help = new LinkedList();
        }

        public int peek() {
            if (queue.isEmpty()) {
                return 0;
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public void push(int v) {
            queue.add(v);
        }

        public int pop() {
            if (queue.isEmpty()) {
                return 0;
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public void swap() {
            Queue tem = help;
            help = queue;
            queue = tem;
        }
    }


}
