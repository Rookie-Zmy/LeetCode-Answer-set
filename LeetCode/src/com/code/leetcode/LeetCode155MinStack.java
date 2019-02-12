package com.code.leetcode;

import java.util.LinkedList;

public class LeetCode155MinStack {

    public static void main(String args[]) {
        MinStack minStack = new LeetCode155MinStack().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    class MinStack {
        private LinkedList stack;
        private int minPos, minValue;

        public MinStack() {
            stack = new LinkedList<Integer>();
            minPos = -1;
            minValue = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.addFirst(x);

            if (x <= minValue) {
                minPos = 0;
                minValue = x;
            } else {
                minPos++;
            }
        }

        public void pop() {
            stack.pop();
            if (minPos == 0) {
                updateMinPos();
            } else {
                minPos--;
            }
        }

        public int top() {
            return (int) stack.getFirst();
        }

        public int getMin() {
            return (int) stack.get(minPos);
        }

        // 当pop了当前的最小的element时,进行刷新
        // 不保证多线程安全
        private void updateMinPos() {
            minValue = Integer.MAX_VALUE;
            int pos = 0;
            for (Object value : stack) {
                if ((int) value <= minValue) {
                    minValue = (int) value;
                    minPos = pos;
                }
                pos++;
            }
        }
    }

    /*
    // 其他人的提交代码，时间复杂度为O(1)，空间复杂度为O(n);
    // 因stack的操作是单方向的，故其某个节点为top时对应的stack的min值是单调的，;
    public void push(int x) {
        int min = x;
        if(top!=null&&top.min<x){
            min = top.min;
        }
        top = new Node(x,top);
        top.min = min;
    }
    class Node{
        private final int val;
        private Node next;
        private int min;

        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }

        public int getVal(){
            return val;
        }

        public Node getNext(){
            return next;
        }
    }
    */
}
