package com.code.leetcode;

import java.util.Stack;

// DP解法：dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
public class LeetCode221MaximalSquare {
    public static void main(String[] args) {
        LeetCode221MaximalSquare temp = new LeetCode221MaximalSquare();
        System.out.println(temp.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
        System.out.println(temp.maximalSquare(new char[][]{
                {'1', '0'},
                {'0', '1'},
        }));
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m;
        if (n == 0) {
            return 0;
        }
        m = matrix[0].length;
        int[] height = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            ans = Math.max(ans, getLargestSquare(height));
        }
        return ans;
    }

    private int getLargestSquare(int[] height) {
        int n = height.length, ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.empty() && (i == n || height[stack.peek()] > height[i])) {
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - 1 - stack.peek();
                if (w > h) w = h;
                else h = w;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }
}
