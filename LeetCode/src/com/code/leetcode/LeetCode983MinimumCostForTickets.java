package com.code.leetcode;

public class LeetCode983MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int ans = 0;
        int[] dayMap = new int[366];
        int[] pay = new int[366];
        int last = 0, daysPoint = 0;
        for (int i = 0; i < dayMap.length; i++) {
            if (daysPoint < days.length && i == days[daysPoint]) {
                last = days[daysPoint++];
            }
            dayMap[i] = last;
        }
        for (int i = 0; i < days.length; i++) {
            pay[days[i]] = Math.min(pay[dayMap[days[i] - 1 >= 0 ? days[i] - 1 : 0]] + costs[0], pay[dayMap[days[i] - 7 >= 0 ? days[i] - 7 : 0]] + costs[1]);
            pay[days[i]] = Math.min(pay[days[i]], pay[dayMap[days[i] - 30 >= 0 ? days[i] - 30 : 0]] + costs[2]);
        }

        ans = pay[days[days.length - 1]];
        return ans;
    }

    public static void main(String args[]) {
        LeetCode983MinimumCostForTickets temp = new LeetCode983MinimumCostForTickets();
        System.out.println(temp.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(temp.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
}
