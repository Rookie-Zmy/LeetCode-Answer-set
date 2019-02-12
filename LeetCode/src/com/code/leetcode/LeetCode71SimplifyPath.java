package com.code.leetcode;

import java.util.Stack;

public class LeetCode71SimplifyPath {

    public static void main(String args[]) {
        LeetCode71SimplifyPath temp = new LeetCode71SimplifyPath();
        System.out.println(temp.simplifyPath("/home/"));
        System.out.println(temp.simplifyPath("/../"));
        System.out.println(temp.simplifyPath("/home//foo/"));
        System.out.println(temp.simplifyPath("/a/./b/../../c/"));
        System.out.println(temp.simplifyPath("/a/../../b/../c//.//"));
    }

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        String[] pathArray = path.split("/");
        Stack stack = new Stack<String>();
        for (String value : pathArray) {
            if (value.equals(".")) {
                continue;
            } else if (value.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!value.equals("")) {
                stack.push(value);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        for (Object value : stack) {
            builder.append("/");
            builder.append((String) value);
        }
        return builder.toString();
    }
}
