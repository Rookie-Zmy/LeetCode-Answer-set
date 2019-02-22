package com.code.leetcode;

import java.math.BigInteger;
import java.util.Stack;

// 更好的算法：使用递归处理
public class LeetCode224BasicCalculator {

    public static void main(String args[]) {
        LeetCode224BasicCalculator temp = new LeetCode224BasicCalculator();
        System.out.println(temp.calculate("1 + 1"));
        System.out.println(temp.calculate(" 2-1 + 2 "));
        System.out.println(temp.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(temp.calculate("2-(5-6)"));
        System.out.println(temp.calculate("(5-(1+(5)))"));
    }

    public int calculate(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        stack.push(builder);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || c == '+' || c == '-') {
                builder.append(c);
            } else if (c == '(') {
                builder = new StringBuilder();
                stack.push(builder);
            } else if (c == ')') {
                int value = calculateResult(stack.pop().toString());
                if (stack.empty()) {
                    builder = new StringBuilder(value);
                    stack.push(builder);
                } else {
                    stack.peek().append(value);
                    builder = stack.peek();
                }
            }
        }
        return calculateResult(stack.pop().toString());
    }

    private int calculateResult(String s) {
        s = s.replace("--", "+");
        StringBuilder builder = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                builder.append('+');
            }
            builder.append(c);
        }
        String[] numArray = builder.toString().split("\\+");
        for (String value : numArray) {
            if (value.equals("")) continue;
            ans += Integer.parseInt(value);
        }
        return ans;
    }
}
