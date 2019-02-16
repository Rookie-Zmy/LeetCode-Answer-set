package com.code.leetcode;

public class LeetCode84LargestRectangleInHistogram {
    public static void main(String args[]) {
        LeetCode84LargestRectangleInHistogram temp = new LeetCode84LargestRectangleInHistogram();
        System.out.println(temp.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(temp.largestRectangleArea(new int[]{2, 5, 5, 6, 4, 4}));
        System.out.println(temp.largestRectangleArea(new int[]{2, 5, 5, 6, 4, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int minH[][] = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            minH[i][i] = heights[i];
            ans = Math.max(ans, minH[i][i]);
            for (int j = i + 1; j < n; j++) {
                minH[i][j] = Math.min(minH[i][j - 1], heights[j]);
                ans = Math.max(ans, (j - i + 1) * minH[i][j]);
            }
        }
        return ans;
    }
}
