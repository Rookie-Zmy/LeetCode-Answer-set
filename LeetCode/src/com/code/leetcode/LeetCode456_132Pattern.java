package com.code.leetcode;

public class LeetCode456_132Pattern {
    public static void main(String args[]) {
        LeetCode456_132Pattern temp = new LeetCode456_132Pattern();
        System.out.println(temp.find132pattern(new int[]{1, 2, 3, 6, 5, 1}));
        System.out.println(temp.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(temp.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(temp.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(temp.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(temp.find132pattern(new int[]{-1, 3, 2, 0, 5, 1}));
    }

    /*public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int aj = Integer.MIN_VALUE;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] > nums[i] && nums[k] < aj) {
                    return true;
                } else {
                    if (nums[k] > nums[i] && nums[k] > aj) {
                        aj = nums[k];
                    }
                }
            }
        }
        return false;
    }*/

    // 参考了他人思路，
    // 本质上还是贪心思想，确定ai，ak找aj，
    // 左右遍历，依次缩小单边，
    // 当ai < ak时，可以获得更小的ai或ak即更新ai,ak
    // 当ai >= ak时，若new ak > ak and ak > ai时更新ak
    // ai,ak不需要更新值得时候，取大的值进行单边的缩小
//    public boolean find132pattern(int[] nums) {
//        if (nums.length == 0){
//            return false;
//        }
//        int left = nums[0], right = nums[nums.length - 1];
//        int start = 1, end = nums.length - 2;
//        while (start <= end) {
//            if (left < right && (nums[start] > right || nums[end] > right)) {
//                return true;
//            }
//            if (left >= nums[start]) {
//                left = nums[start++];
//            } else if ((right >= nums[end] && nums[end] > left) || (left >= right && nums[end] > left)) {
//                right = nums[end--];
//            } else {
//                if (nums[end] > nums[start]) {
//                    end--;
//                } else {
//                    start++;
//                }
//            }
//        }
//        return false;
//    }

    // 其他人的思路，根据aj确定ak最大取值再确定ai是否符合条件
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, min = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--){
            if (nums[i] < min) return true;
            while (top < n && nums[i] > nums[top]){
                min = nums[top++];
            }
            // 更新最大值
            nums[--top] = nums[i];
        }
        return false;
    }
}
