package com.code.leetcode;

public class LeetCode225ImplementStackUsingQueues {

    public static void main(String args[]) {
        MyStack myStack = new LeetCode225ImplementStackUsingQueues().new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    class MyStack {
        Node cursor;
        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            cursor = null;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if(cursor == null){
                cursor = new Node(x);
                cursor.setNext(null);
                cursor.setPre(null);
            } else {
                Node newNode = new Node(x);
                newNode.pre = cursor;
                cursor.next = newNode;
                cursor = cursor.next;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int ans = cursor.value;
            cursor = cursor.pre;
            if (cursor != null){
                cursor.next = null;
            }
            return ans;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return cursor.value;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return cursor == null;
        }

        class Node {
            int value;
            Node next, pre;

            public Node(int x) {
                value = x;
            }

            public void setNext(Node node){
                next = node;
            }

            public Node getNext(){
                return next;
            }

            public void setPre(Node node){
                pre = node;
            }

            public Node getPre(){
                return pre;
            }
        }
    }
}
