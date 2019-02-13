package com.code.leetcode;

import java.util.Arrays;

public class LeetCode503NextGreaterElem2 {
    public static void main(String args[]) {
        LeetCode503NextGreaterElem2 temp = new LeetCode503NextGreaterElem2();
        int[] ans = temp.nextGreaterElements(new int[]{1, 2, 1});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.nextGreaterElements(new int[]{2, -1, 2});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
        System.out.println();
        ans = temp.nextGreaterElements(new int[]{-3, -2, -2, -3});
        for (int value : ans) {
            System.out.printf("%d ", value);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, Integer.MIN_VALUE);
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = (i + 1) % nums.length;
            while (temp != i) {
                if (nums[temp] > nums[i]) {
                    nextGreater[i] = nums[temp];
                    break;
                } else if (nextGreater[temp] > nums[i]) {
                    nextGreater[i] = nextGreater[temp];
                    break;
                } else {
                    if (nums[temp] == nums[i] && nextGreater[temp] > Integer.MIN_VALUE){
                        nextGreater[i] = nextGreater[temp];
                        break;
                    }

                    temp++;
                    if (temp == nums.length) {
                        temp = 0;
                    }
                }
            }
            if (temp == i) {
                nextGreater[i] = -1;
            }
        }
        return nextGreater;
    }
}
