package com.code.leetcode;

import java.util.Stack;

public class LeetCode921MinimumAddToMakeParenthesesValid {
    public static void main(String args[]) {
        LeetCode921MinimumAddToMakeParenthesesValid temp = new LeetCode921MinimumAddToMakeParenthesesValid();
        System.out.println(temp.minAddToMakeValid("())"));
        System.out.println(temp.minAddToMakeValid("((("));
        System.out.println(temp.minAddToMakeValid("()"));
        System.out.println(temp.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.empty() || c == '(') {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (top == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}
