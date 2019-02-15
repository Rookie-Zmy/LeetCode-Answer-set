package com.code.leetcode;

public class LeetCode946ValidateStackSequences {
    public static void main(String args[]) {
        LeetCode946ValidateStackSequences temp = new LeetCode946ValidateStackSequences();
        System.out.println(temp.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(temp.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int[] stack = new int[pushed.length];
        int stackCursor = 0, cursor = 0;
        for (int value : pushed) {
            stack[stackCursor++] = value;
            while (stackCursor > 0 && stack[stackCursor - 1] == popped[cursor]) {
                stackCursor--;
                cursor++;
            }
        }
        return stackCursor == 0 && cursor == popped.length;
    }
}
