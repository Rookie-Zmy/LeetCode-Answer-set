package com.code.leetcode;

import java.util.Stack;

public class LeetCode880DecodedStringAtIndex {
    public static void main(String args[]) {
        LeetCode880DecodedStringAtIndex temp = new LeetCode880DecodedStringAtIndex();
//        System.out.println(temp.decodeAtIndex("leet2code3", 10));
//        System.out.println(temp.decodeAtIndex("ha22", 5));
        System.out.println(temp.decodeAtIndex("a2345678999999999999999", 1));
//        System.out.println(temp.decodeAtIndex("a2b3c42d5", 100));
//        System.out.println(temp.decodeAtIndex("ha22", 6));
    }

    // 愚蠢的模拟实现
//    public String decodeAtIndex(String S, int K) {
//        Stack<StringBuilder> str = new Stack<>();
//        Stack<Integer> num = new Stack<>();
//        StringBuilder topBuilder = new StringBuilder();
//        int topNum = 0;
//        for (char c : S.toCharArray()) {
//            if (c >= '0' && c <= '9') {
//                if (topBuilder.length() == 0) {
//                    if (num.empty()) {
//                        continue;
//                    }
//                    topNum = num.pop() * (c - '0');
//                    num.push(topNum);
//                } else {
//                    topNum = (topNum + topBuilder.length()) * (c - '0');
//                    str.push(topBuilder);
//                    num.push(topNum);
//                    topBuilder = new StringBuilder();
//                }
//                while (num.peek() >= K) {
//                    num.pop();
//
//                    int lastNum = 0;
//                    if (!num.empty()) lastNum = num.peek();
//                    int last = str.peek().length() + lastNum;
//                    K %= last;
//
//                    if (K == 0)
//                        return str.peek().charAt(str.peek().length() - 1) + "";
//                    else if (K > lastNum)
//                        return str.peek().charAt(K - lastNum - 1) + "";
//                    else {
//                        if (lastNum == 0) return str.peek().charAt(K - 1) + "";
//                        else str.pop();
//                    }
//                }
//            } else {
//                topBuilder.append(c);
//                if (topNum + topBuilder.length() == K) {
//                    return c + "";
//                }
//            }
//        }
//        return "";
//    }

    // 其他人的做法
    public String decodeAtIndex(String S, int K) {
        int size = 0;
        char[] array = S.toCharArray();
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (int) c - '0';
            } else {
                size++;
            }
            System.out.println(size);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            K = size == 0 ? 0 : K % size;
            if (K == 0 && !Character.isDigit(array[i])){
                return Character.toString(array[i]);
            }
            if (Character.isDigit(array[i])){
                size /= array[i] - '0';
            }else {
                size--;
            }
        }

        return "";
    }
}
