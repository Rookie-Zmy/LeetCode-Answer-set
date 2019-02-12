package com.code.leetcode;

import java.util.*;

//LeetCode144、LeetCode145的解法也适用与该方法，修改push顺序即可
public class LeetCode94BinaryTreeInorderTraversal {
    public static void main(String args[]) {
        LeetCode94BinaryTreeInorderTraversal temp = new LeetCode94BinaryTreeInorderTraversal();
        TreeNode head = temp.new TreeNode(1);
        head.left = temp.new TreeNode(5);
        head.left.left = temp.new TreeNode(9);
        head.left.right = temp.new TreeNode(10);
        head.right = temp.new TreeNode(2);
        head.right.left = temp.new TreeNode(3);
        head.right.right = temp.new TreeNode(18);
        System.out.println(temp.inorderTraversal(head));
    }

    // 递归写法，递归写法存在栈深度过深的问题
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        if (root.left != null){
            ans.addAll(inorderTraversal(root.left));
        }
        ((LinkedList<Integer>) ans).addLast(root.val);
        if (root.right != null){
            ans.addAll(inorderTraversal(root.right));
        }

        return ans;
    }*/

    // 非递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // set用来进行标记该节点是否已经进行过处理
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            if (set.contains(temp)) {
                ((LinkedList<Integer>) ans).addLast(temp.val);
                continue;
            } else {
                set.add(temp);
            }
            // 交换push顺序,即可分别实现先序、中序、后序
            if (temp.right != null) {
                stack.push(temp.right);
            }
            stack.push(temp);
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return ans;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
