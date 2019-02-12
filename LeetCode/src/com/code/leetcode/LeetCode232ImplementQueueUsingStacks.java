package com.code.leetcode;

public class LeetCode232ImplementQueueUsingStacks {

    public static void main(String args[]) {
        MyQueue myQueue = new LeetCode232ImplementQueueUsingStacks().new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    class MyQueue {

        Node head, tail;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            head = null;
            tail = null;
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Node newNode = new Node(x);
            if (head == null) {
                head = newNode;
            }
            if (tail == null) {
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = tail.next;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int ans = head.value;
            head = head.next;
            if (head != null) {
                head.pre = null;
            } else {
                tail = null;
            }
            return ans;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return head.value;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return head == null;
        }

        class Node {
            private int value;
            private Node pre, next;

            public Node(int x) {
                value = x;
                pre = null;
                next = null;
            }
        }
    }
}