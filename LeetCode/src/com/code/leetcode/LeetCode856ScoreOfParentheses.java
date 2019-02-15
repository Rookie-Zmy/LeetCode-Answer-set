package com.code.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

public class LeetCode856ScoreOfParentheses {
    public static void main(String args[]) {
        LeetCode856ScoreOfParentheses temp = new LeetCode856ScoreOfParentheses();
        System.out.println(temp.scoreOfParentheses("()"));
        System.out.println(temp.scoreOfParentheses("(())"));
        System.out.println(temp.scoreOfParentheses("()()"));
        System.out.println(temp.scoreOfParentheses("(()(()))"));
        System.out.println(temp.scoreOfParentheses("(()(())(()))"));
    }

    /*public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(1);
            } else {
                int temp = stack.pop();
                temp = temp > 1 ? temp - 1 : temp;
                if (!stack.empty()) {
                    stack.push(stack.pop() + temp * 2);
                } else {
                    ans += temp;
                }
            }
        }
        return ans;
    }*/

    public int scoreOfParentheses(String S) {
        int[] stack = new int[S.length()/2];
        int ans = 0, top = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack[top++] = 1;
            } else {
                int temp = stack[--top];
                temp = temp > 1 ? temp - 1 : temp;
                if (top > 0) {
                    stack[top - 1] += temp * 2;
                } else {
                    ans += temp;
                }
            }
        }
        return ans;
    }
}
