package com.code.leetcode;

import java.util.Stack;

public class LeetCode735AsteroidCollision {
    public static void main(String[] args) {
        LeetCode735AsteroidCollision temp = new LeetCode735AsteroidCollision();
        int[] ans = temp.asteroidCollision(new int[]{5, 10, -5});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.asteroidCollision(new int[]{8, -8});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.asteroidCollision(new int[]{10, 2, -5});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.asteroidCollision(new int[]{-2, -1, 1, 2});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.asteroidCollision(new int[]{2, 5, 10, -10, -5, -3});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int value : asteroids) {
            if (stack.empty()) {
                stack.push(value);
            } else {
                boolean flag = false;
                while (!stack.empty()) {
                    int top = stack.peek();
                    if (!(top > 0 && value < 0)) {
                        flag = true;
                        stack.push(value);
                        break;
                    } else {
                        if (Math.abs(top) > Math.abs(value)) {
                            flag = true;
                            break;
                        } else if (Math.abs(top) == Math.abs(value)) {
                            flag = true;
                            stack.pop();
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
                if (!flag) {
                    stack.push(value);
                }
            }
        }
        int n = stack.size();
        int[] ans = new int[n];
        while (--n >= 0) {
            ans[n] = stack.pop();
        }
        return ans;
    }
}
