package com.basic.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {
    public int a;

    public static void main(String[] args) {
//        TwoQueuesStack twoQueuesStack = new TwoQueuesStack();
//        twoQueuesStack.push(1);
//        twoQueuesStack.push(2);
//        System.out.println(twoQueuesStack.peek());
//		TwoQueuesStack twoQueuesStack1 = new TwoQueuesStack();
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.push(1);
        twoStacksQueue.push(2);
        System.out.println(twoStacksQueue.peek());
    }

    // 将 stackPush 中的元素倒入stackPop中，
    // 若stackPop 不为空，则依次弹出stackPop 中的元素
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);


        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
//            Queue<Integer> integers = new Queue<>();
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        // 将queue 中的元素依次弹出加入到 help 队列中，直至剩下一个元素，
        // 之后交换两个队列的引用
        public int peek() {

            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

}
