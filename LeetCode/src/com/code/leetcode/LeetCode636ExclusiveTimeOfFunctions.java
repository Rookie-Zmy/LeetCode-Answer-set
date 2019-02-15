package com.code.leetcode;

import javafx.util.Pair;

import java.util.*;

public class LeetCode636ExclusiveTimeOfFunctions {
    public static void main(String args[]) {
        LeetCode636ExclusiveTimeOfFunctions temp = new LeetCode636ExclusiveTimeOfFunctions();
        int[] ans = temp.exclusiveTime(2, new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }
        System.out.println();
        ans = temp.exclusiveTime(8, new ArrayList<>(Arrays.asList(
                "0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14", "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114")));
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }
        System.out.println();
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Pair<String, String>> stack = new Stack<>();
        ListIterator iterator = logs.listIterator();
        while (iterator.hasNext()){
            String temp = (String) iterator.next();
            String[] strArray = temp.split(":");
            if (strArray[1].equals("start")){
                stack.push(new Pair<>(strArray[0], strArray[2]));
            } else {
                Pair pair = stack.pop();
                int time = Integer.parseInt(strArray[2]) - Integer.parseInt((String) pair.getValue()) + 1;
                ans[Integer.parseInt(strArray[0])] += time;
                if (!stack.empty()){
                    ans[Integer.parseInt(stack.peek().getKey())] -= time;
                }
            }
        }
        return ans;
    }
}
