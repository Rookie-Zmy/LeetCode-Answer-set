package com.code.leetcode;

import javafx.util.Pair;

import java.util.Stack;

public class LeetCode331VerifyPreorderSerializationOfABinaryTree {
    public static void main(String args[]) {
        LeetCode331VerifyPreorderSerializationOfABinaryTree temp = new LeetCode331VerifyPreorderSerializationOfABinaryTree();
        System.out.println(temp.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(temp.isValidSerialization("1,#"));
        System.out.println(temp.isValidSerialization("9,#,#,1"));
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        String[] array = preorder.split(",");
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        for (String value : array) {
            if (!flag && stack.empty()) {
                if (value.equals("#")) {
                    return false;
                }
                stack.push(new TreeNode(Integer.parseInt(value)));
                flag = true;
            } else if (stack.empty()) {
                return false;
            } else {
                TreeNode top = stack.peek();
                TreeNode newNode = null;
                if (!value.equals("#")) {
                    newNode = new TreeNode(Integer.parseInt(value));
                }
                if (!top.setNext(newNode)) {
                    return false;
                }
                if (!top.check()) {
                    stack.pop();
                }
                if (newNode != null) {
                    stack.push(newNode);
                }
            }
        }
        return stack.empty();
    }

    // 利用空叶子节点数量比所有节点数量总和多1的特点的代码实现
    /*public boolean isValidSerialization(String kupreorder) {
        char[] chars = preorder.toCharArray();
        int i = 0, count = 0;
        for (; i < chars.length && count != -1; i += 2) {
            if (chars[i] != '#') {
                while (i < chars.length && chars[i] != ',') ++i;
                --i;
            }
            count = chars[i] == '#'? count - 1 : count + 1;
        }
        return i >= chars.length && count == -1;
    }*/

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean flagLeft;
        boolean flagRight;

        TreeNode(int x) {
            val = x;
            flagLeft = false;
            flagRight = false;
        }

        boolean setNext(TreeNode node) {
            if (!check()) {
                return false;
            } else if (!flagLeft) {
                left = node;
                flagLeft = true;
            } else {
                right = node;
                flagRight = true;
            }
            return true;
        }

        // 检查子节点是否都有了
        boolean check() {
            return !(flagRight && flagLeft);
        }
    }
}
