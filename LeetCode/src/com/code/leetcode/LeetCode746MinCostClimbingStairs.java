package com.code.leetcode;

public class LeetCode746MinCostClimbingStairs {
    public static void main(String args[]) {
        LeetCode746MinCostClimbingStairs temp = new LeetCode746MinCostClimbingStairs();
        System.out.println(temp.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(temp.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int f0 = cost[0], f1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = f1 > f0 ? f0 + cost[i] : f1 + cost[i];
            f0 = f1;
            f1 = temp;
        }
        return Math.min(f0, f1);
    }
}
