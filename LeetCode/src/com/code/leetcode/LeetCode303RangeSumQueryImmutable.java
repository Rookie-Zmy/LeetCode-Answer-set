package com.code.leetcode;

import java.util.Arrays;

public class LeetCode303RangeSumQueryImmutable {

    public static void main(String args[]) {
        LeetCode303RangeSumQueryImmutable temp = new LeetCode303RangeSumQueryImmutable();

        NumArray numArray = temp.new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    class NumArray {
        private int[] cache;

        public NumArray(int[] nums) {
            cache = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                cache[i] = nums[i];
                if (i != 0) cache[i] += cache[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) return cache[j];
            return cache[j] - cache[i - 1];
        }
    }
}
