package com.code.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode150EvaluateReversePolishNotation {
    public static void main(String args[]) {
        LeetCode150EvaluateReversePolishNotation temp = new LeetCode150EvaluateReversePolishNotation();
        System.out.println(temp.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(temp.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(temp.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String value : tokens) {
            switch (value) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(value));
                    break;
            }
        }

        if (stack.empty()) {
            return 0;
        }
        return stack.peek();
    }
}
