package com.code.leetcode;

public class LeetCode53MaximumSubarray {
    public static void main(String args[]) {
        LeetCode53MaximumSubarray temp = new LeetCode53MaximumSubarray();
        System.out.println(temp.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = 0, ans = Integer.MIN_VALUE;
        for (int value : nums) {
            max = Math.max(max + value, value);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
