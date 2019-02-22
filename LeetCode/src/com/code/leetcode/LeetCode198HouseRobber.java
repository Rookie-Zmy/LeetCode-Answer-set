package com.code.leetcode;

public class LeetCode198HouseRobber {
    public static void main(String args[]) {
        LeetCode198HouseRobber temp = new LeetCode198HouseRobber();
        System.out.println(temp.rob(new int[]{1, 2, 3, 1}));
        System.out.println(temp.rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int f0 = nums[0], f1 = Math.max(nums[0], nums[1]), max = 0;
        for (int i = 2; i < n; i++) {
            max = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = max;
        }
        return max;
    }
}
