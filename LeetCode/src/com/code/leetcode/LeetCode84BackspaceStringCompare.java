package com.code.leetcode;

public class LeetCode84BackspaceStringCompare {

    public static void main(String argsp[]){
        LeetCode84BackspaceStringCompare temp = new LeetCode84BackspaceStringCompare();
        System.out.println(temp.backspaceCompare("ab#c", "ad#c"));
        System.out.println(temp.backspaceCompare("ab##", "c#d#"));
        System.out.println(temp.backspaceCompare("a##c", "#a#c"));
        System.out.println(temp.backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder builder = new StringBuilder();
        String[] value = {S, T};
        String[] ans = new String[2];
        for (int i = 0; i < value.length; i++) {
            if (builder.length() != 0) {
                builder.delete(0, builder.length());
            }
            for (int j = 0; j < value[i].length(); j++) {
                if (value[i].charAt(j) == '#') {
                    int len = builder.length();
                    if (len > 0) {
                        builder.delete(len - 1, len);
                    }
                } else {
                    builder.append(value[i].charAt(j));
                }
            }
            ans[i] = builder.toString();
        }

        return ans[0].equals(ans[1]);
    }
}
