package com.code.leetcode;

public class LeetCode70ClimbingStairs {
    public static void main(String args[]){
        LeetCode70ClimbingStairs temp = new LeetCode70ClimbingStairs();
        System.out.println(temp.climbStairs(2));
        System.out.println(temp.climbStairs(3));
        System.out.println(temp.climbStairs(4));
        System.out.println(temp.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f0 = 1, f1 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = f0 + f1;
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}
