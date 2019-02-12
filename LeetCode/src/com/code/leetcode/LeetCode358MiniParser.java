package com.code.leetcode;

import java.util.*;

public class LeetCode358MiniParser {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
//          public NestedInteger();

        // Constructor initializes a single integer.
//          public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class SolidInteger implements NestedInteger {

        private Integer integer;
        private List<NestedInteger> list;

        public SolidInteger() {
            list = new LinkedList<>();
        }

        public SolidInteger(int value) {
            integer = value;
        }

        @Override
        public boolean isInteger() {
            return integer != null;
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public void setInteger(int value) {
            integer = value;
        }

        @Override
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            if (integer != null) {
                return integer.toString();
            } else {
                return list.toString();
            }
        }
    }

    public NestedInteger deserialize(String s) {
        char[] charArray = s.toCharArray();
        Stack<NestedInteger> stack = new Stack<>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ',') {
                if (builder.length() > 0) {
                    stack.peek().add(new SolidInteger(Integer.parseInt(builder.toString())));
                    builder.delete(0, builder.length());
                }
                continue;
            } else if (charArray[i] == '[') {
                if (stack.size() == 0) {
                    stack.push(new SolidInteger());
                } else {
                    NestedInteger nestedInteger = new SolidInteger();
                    stack.peek().add(nestedInteger);
                    stack.push(nestedInteger);
                }
                // push list
            } else if (charArray[i] == ']') {
                if (builder.length() > 0) {
                    stack.peek().add(new SolidInteger(Integer.parseInt(builder.toString())));
                    builder.delete(0, builder.length());
                }
                if (stack.size() == 1) {
                    return stack.peek();
                }
                stack.pop();
                // pop list
            } else {
                builder.append(charArray[i]);
            }
        }
        return new SolidInteger(Integer.parseInt(s));
    }

    public static void main(String args[]) {
        LeetCode358MiniParser temp = new LeetCode358MiniParser();
        System.out.println(temp.deserialize("324"));
        System.out.println(temp.deserialize("[123,[456,[789]]]"));
        System.out.println(temp.deserialize("[123]"));
        System.out.println(temp.deserialize("[123,456]"));
        System.out.println(temp.deserialize("[123,[456]]"));
        System.out.println(temp.deserialize("[123,[456],[]]"));
        System.out.println(temp.deserialize("[123,[456],[]]"));
        System.out.println(temp.deserialize("[]"));
        System.out.println(temp.deserialize("[[],2,[],2,[]]"));
    }
}
