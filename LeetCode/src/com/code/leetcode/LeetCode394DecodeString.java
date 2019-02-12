package com.code.leetcode;

import java.util.Stack;

public class LeetCode394DecodeString {
    public static void main(String[] args) {
        LeetCode394DecodeString temp = new LeetCode394DecodeString();
        System.out.println(temp.decodeString("3[a]2[bc]"));
        System.out.println(temp.decodeString("3[a2[c]]"));
        System.out.println(temp.decodeString("2[abc]3[cd]ef"));

    }

    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder nBuilder = new StringBuilder();
        Stack<Integer> stackNums = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                nBuilder.append(charArray[i]);
            } else if (charArray[i] == '[') {
                if (nBuilder.length() > 0) {
                    stackNums.push(Integer.parseInt(nBuilder.toString()));
                    nBuilder.delete(0, nBuilder.length());
                }
                stack.push(new StringBuilder());
            } else if (charArray[i] == ']') {
                int multiples = stackNums.empty() ? 1 : stackNums.pop();
                StringBuilder builder = stack.pop();
                StringBuilder top = stack.peek();
                while (multiples-- > 0) {
                    top.append(builder.toString());
                }
            } else {
                stack.peek().append(charArray[i]);
            }
        }
        return stack.pop().toString();
    }
}
