package com.code.leetcode;

import java.util.*;

public class LeetCode901OnlineStockSpan {
    public static void main(String args[]) {
        StockSpanner temp = new LeetCode901OnlineStockSpan().new StockSpanner();
        System.out.println(temp.next(100));
        System.out.println(temp.next(80));
        System.out.println(temp.next(60));
        System.out.println(temp.next(70));
        System.out.println(temp.next(60));
        System.out.println(temp.next(75));
        System.out.println(temp.next(85));

        System.out.println();
        StockSpanner temp2 = new LeetCode901OnlineStockSpan().new StockSpanner();
        System.out.println(temp2.next(31));
        System.out.println(temp2.next(41));
        System.out.println(temp2.next(48));
        System.out.println(temp2.next(59));
        System.out.println(temp2.next(79));
    }

    class StockSpanner {
        private ArrayList list;
        private Map<Integer, Integer> map;
        private int top;

        public StockSpanner() {
            map = new HashMap<>();
            list = new ArrayList();
            top = 0;
        }

        public int next(int price) {
            if (list.size() == 0) {
                map.put(top++, top - 2);
                list.add(price);
                return 1;
            } else {
                int topValue = (int) list.get(top - 1);
                if (topValue > price) {
                    list.add(price);
                    map.put(top++, top - 2);
                    return 1;
                } else {
                    int tempTop = top - 1;
                    while (tempTop >= 0 && topValue <= price) {
                        tempTop = map.get(tempTop);
                        if (tempTop < 0) {
                            break;
                        } else {
                            topValue = (int) list.get(tempTop);
                        }
                    }
                    map.put(top++, tempTop);
                    list.add(price);
                    return top - tempTop - 1;
                }
            }
        }
    }
}
