package com.code.leetcode;

//Given two integers A and B, return any string S such that:
//
//        S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
//        The substring 'aaa' does not occur in S;
//        The substring 'bbb' does not occur in S.
//
//
//        Example 1:
//
//        Input: A = 1, B = 2
//        Output: "abb"
//        Explanation: "abb", "bab" and "bba" are all correct answers.
//        Example 2:
//
//        Input: A = 4, B = 1
//        Output: "aabaa"
//
//
//        Note:
//
//        0 <= B <= 100
//        It is guaranteed such an S exists for the given A and B.
//        0 <= A <= 100

public class LeetCode984_String_Without_AAA_or_BBB {
    /**
     * @return string
     * @Author zhoumingyu
     * @Description get string without 3a3b
     * @Param int A number of 'a', int B number of 'b'
     * @Date 2019/1/30
     **/
    public String strWithout3a3b(int A, int B) {
        String ans = null;
        char a = 'a', b = 'b', c = A >= B ? 'a' : 'b';
        int C;
        if (A >= B) {
            C = A - B;
            A = A - C;
        } else {
            C = B - A;
            B = B - C;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (A > 0 || B > 0 || C > 0) {
            if (A > 0) {
                if (c == a) stringBuilder.append(a);
                else stringBuilder.append(b);
                A--;
            }
            if (C-- > 0) stringBuilder.append(c);
            if (B > 0) {
                if (c == a) stringBuilder.append(b);
                else stringBuilder.append(a);
                B--;
            }
        }
        ans = stringBuilder.toString();
        return ans;
    }

    public static void main(String[] args) {
        LeetCode984_String_Without_AAA_or_BBB temp = new LeetCode984_String_Without_AAA_or_BBB();
        System.out.println(temp.strWithout3a3b(1, 2));
        System.out.println(temp.strWithout3a3b(4, 1));
        System.out.println(temp.strWithout3a3b(1, 4));
        System.out.println(temp.strWithout3a3b(3, 3));
        System.out.println(temp.strWithout3a3b(1, 1));
        System.out.println(temp.strWithout3a3b(5, 5));
        System.out.println(temp.strWithout3a3b(5, 6));
        System.out.println(temp.strWithout3a3b(5, 7));
        System.out.println(temp.strWithout3a3b(5, 8));
    }
}
