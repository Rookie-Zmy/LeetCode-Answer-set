package com.code.leetcode;

import java.util.Stack;

import static java.util.Arrays.sort;

public class LeetCode853CarFleet {
    public static void main(String args[]) {
        LeetCode853CarFleet temp = new LeetCode853CarFleet();
        System.out.println(temp.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(temp.carFleet(660732, new int[]{620831,145366,229113,144305,382893,514856,171642,87230,409014,65613}, new int[]{327716,69772,667805,856849,78755,606982,696937,207697,275337,290550}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }

        int n = position.length;
        Car car[] = new Car[n];
        for (int i = 0; i < n; i++) {
            car[i] = new Car(position[i], speed[i]);
        }
        sort(car, (a, b) -> {
            if (a.position < b.position) {
                return 1;
            } else if (a.position == b.position) {
                return 0;
            } else {
                return -1;
            }
        });

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            int top = stack.peek();
            if ((target - car[top].position) * (long)car[i].speed < (target - car[i].position) * (long)car[top].speed) {
                stack.push(i);
            }
        }
        return stack.size();
    }

    public class Car {
        int position;
        int speed;

        Car(int p, int s) {
            position = p;
            speed = s;
        }
    }
}
