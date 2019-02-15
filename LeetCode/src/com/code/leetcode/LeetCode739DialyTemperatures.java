package com.code.leetcode;

public class LeetCode739DialyTemperatures {
    public static void main(String args[]) {
        LeetCode739DialyTemperatures temp = new LeetCode739DialyTemperatures();
        int[] ans = temp.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }
        System.out.println();
    }

    public int[] dailyTemperatures(int[] T) {
        int ans[] = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i + 1] > T[i]) {
                ans[i] = i + 1;
            } else {
                int temp = ans[i + 1];
                while (temp != 0 && temp < T.length) {
                    System.out.println(temp);
                    if (T[temp] > T[i]) {
                        ans[i] = temp;
                        break;
                    } else temp = ans[temp];
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                ans[i] = ans[i] - i;
            }
        }
        return ans;
    }
}
