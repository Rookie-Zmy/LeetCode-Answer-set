package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode895MaximumFrequencyStack {
    public static void main(String args[]){
        FreqStack temp = new LeetCode895MaximumFrequencyStack().new FreqStack();
        temp.push(5);
        temp.push(7);
        temp.push(5);
        temp.push(7);
        temp.push(4);
        temp.push(5);
        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
        System.out.println(temp.pop());
    }

    class FreqStack {
        List list;
        public FreqStack() {
            list = new ArrayList();
        }

        public void push(int x) {

        }

        public int pop() {
            return 0;
        }
    }

}
