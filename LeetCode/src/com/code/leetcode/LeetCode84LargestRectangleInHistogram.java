package com.code.leetcode;

import java.util.Stack;

public class LeetCode84LargestRectangleInHistogram {
    public static void main(String args[]) {
        LeetCode84LargestRectangleInHistogram temp = new LeetCode84LargestRectangleInHistogram();
        System.out.println(temp.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(temp.largestRectangleArea(new int[]{2, 5, 5, 6, 4, 4}));
        System.out.println(temp.largestRectangleArea(new int[]{2, 5, 5, 6, 4, 3}));
        System.out.println(temp.largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0}));
    }

    // 其他人的实现方式
    // 维护一个单调递增的栈，因出现较小条时，在前面高度大于该条的所有条，只能用的高度为该条的高度，故维护一个单调栈即可
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.empty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;

                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }

//    public int largestRectangleArea(int[] heights) {
//        int ans = 0, n = heights.length;
//        int[] left = new int[n], right = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            left[i] = i;
//            right[i] = i;
//        }
//
//        for (int i = 1; i < n; i++) {
//            int j = i - 1;
//            if (j >= 0 && heights[j] >= heights[i]) {
//                while (j >= 0 && heights[j] >= heights[i] && heights[left[j]] >= heights[i]) {
//                    j = left[j] - 1;
//                }
//                left[i] = j + 1;
//            }
//        }
//
//        for (int i = n - 2; i >= 0; i--) {
//            int j = i + 1;
//            if (j < n && heights[j] >= heights[i]) {
//                while (j < n && heights[j] >= heights[i] && heights[right[j]] >= heights[i]) {
//                    j = right[j] + 1;
//                }
//                right[i] = j - 1;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            ans = Math.max(ans, (right[i] - left[i] + 1) * heights[i]);
//        }
//
//        return ans;
//    }
}
