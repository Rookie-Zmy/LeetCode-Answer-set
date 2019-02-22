package com.code.leetcode;

public class LeetCode121BestTimeToBuyAndSellStock {
    public static void main(String args[]) {
        LeetCode121BestTimeToBuyAndSellStock temp = new LeetCode121BestTimeToBuyAndSellStock();
        System.out.println(temp.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(temp.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(temp.maxProfit(new int[]{1, 2, 3, 2, 1}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length, ans = 0;
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            max[i] = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (prices[max[i + 1]] > prices[i]) max[i] = max[i + 1];
            ans = Math.max(ans, prices[max[i]] - prices[i]);
        }
        return ans;
    }
}
