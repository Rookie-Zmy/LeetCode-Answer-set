package com.code.leetcode;

import java.util.Arrays;

public class LeetCode316RemoveDuplicateLetters {
    public static void main(String args[]) {
        LeetCode316RemoveDuplicateLetters temp = new LeetCode316RemoveDuplicateLetters();
//        System.out.println(temp.removeDuplicateLetters("bcabc"));
//        System.out.println(temp.removeDuplicateLetters("cbacdcbc"));
//        System.out.println(temp.removeDuplicateLetters("dfqwefdaasdfqr"));
//        System.out.println(temp.removeDuplicateLetters("aaassddffffeeaasd"));
        System.out.println(temp.removeDuplicateLetters("dbede"));
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[27];
        int[] pos = new int[27];
        int letterPos = 0;
        Arrays.fill(pos,-1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            count[c]++;
            pos[c] = i;
            letterPos = Math.max(letterPos, c);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            if (count[c] == 0 || c > letterPos) continue;
            count[c]--;
            pos[c] = i;

            if (count[c] == 0) letterPos = c - 1;
        }
        StringBuilder builder = new StringBuilder();
        Arrays.sort(pos);
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == -1) continue;
            builder.append(s.charAt(pos[i]));
        }

        return builder.toString();
    }
}
