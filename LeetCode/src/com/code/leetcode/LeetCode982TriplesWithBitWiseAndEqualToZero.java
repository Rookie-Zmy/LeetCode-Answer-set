package com.code.leetcode;

public class LeetCode982TriplesWithBitWiseAndEqualToZero {
    public int countTriplets(int[] A) {
        int N = 1 << 16, ans = 0, M = 3;
        int[][] dp = new int[M][N];
        for (int value : A) {
            dp[0][value]++;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int value : A)
                    dp[i][j & value] += dp[i - 1][j];
            }
        }
        ans = dp[M-1][0];
        return ans;
    }

    //该解决方法来自leetcode Accepted Solutions
    public int countTriplets_fromleetcode(int[] A) {
        int[] arr = new int[1<<16];
        int all = (1<<16) - 1;
        for(int num: A){
            int k = all ^ num;
            for(int i=k; ; i = (i-1) & k){
                arr[i ^ num]++;
                if(i == 0) break;
            }
        }

        int n = A.length;
        int res = 0;
        // System.out.println("all --> "+ all);
        for(int i=0; i < n ; i++){
            for(int j=0; j < n ; j++){
                int curr = all ^ (A[i] & A[j]);
                res += arr[curr];
            }
        }

        return res;
    }

    public static void main(String[] args){
        LeetCode982TriplesWithBitWiseAndEqualToZero temp = new LeetCode982TriplesWithBitWiseAndEqualToZero();
        System.out.println(temp.countTriplets(new int[]{2,1,4}));
        System.out.println(temp.countTriplets(new int[]{2,1,3}));
        System.out.println(temp.countTriplets(new int[]{0,0,0}));
    }
}
