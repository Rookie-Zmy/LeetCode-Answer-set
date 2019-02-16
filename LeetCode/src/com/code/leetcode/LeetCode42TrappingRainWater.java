package com.code.leetcode;

public class LeetCode42TrappingRainWater {
    public static void main(String args[]) {
        LeetCode42TrappingRainWater temp = new LeetCode42TrappingRainWater();
        System.out.println(temp.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int temp = Math.min(left[i], right[i]);
            if (temp > height[i]) {
                ans += temp - height[i];
            }
        }
        return ans;
    }
}
