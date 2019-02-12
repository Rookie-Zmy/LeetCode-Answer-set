package com.code.leetcode;

import sun.awt.image.ImageWatched;

import java.util.*;

public class LeetCode103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String args[]) {
        LeetCode103BinaryTreeZigzagLevelOrderTraversal temp = new LeetCode103BinaryTreeZigzagLevelOrderTraversal();
        TreeNode head = temp.new TreeNode(3);
        head.left = temp.new TreeNode(9);
        head.left.left = temp.new TreeNode(8);
        head.left.right = temp.new TreeNode(6);
        head.right = temp.new TreeNode(20);
        head.right.left = temp.new TreeNode(15);
        head.right.left.left = temp.new TreeNode(22);
        head.right.left.right = temp.new TreeNode(28);
        head.right.right = temp.new TreeNode(7);
        head.right.right.left = temp.new TreeNode(30);
        head.right.right.right = temp.new TreeNode(36);
        System.out.println(temp.zigzagLevelOrder(head));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>(Arrays.asList(new LinkedList<>()));
        // depth记录节点的深度
        Map<TreeNode, Integer> depth = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        depth.put(root, 0);
        ans.get(0).add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = ((ArrayDeque<TreeNode>) queue).pop();
            int tempDepth = 0;
            if (temp.left != null || temp.right != null) {
                tempDepth = depth.getOrDefault(temp, 0) + 1;
                if (tempDepth >= ans.size()) {
                    ans.add(new LinkedList<>());
                }
            }

            TreeNode nodeArray[] = new TreeNode[2];
            nodeArray[0] = temp.left;
            nodeArray[1] = temp.right;
            for (TreeNode value : nodeArray) {
                if (value != null) {
                    queue.add(value);
                    depth.put(value, tempDepth);
                    ans.get(tempDepth).add(value.val);
                }
            }
        }
        // 进行翻转
        for (int i = 0; i < ans.size(); i++) {
            if ((i&1) != 0){
                List<Integer> tempList = ans.get(i);
                for (int j = 0; j < tempList.size() / 2; j++) {
                    int swapValue = tempList.get(j);
                    tempList.set(j, tempList.get(tempList.size() - j - 1));
                    tempList.set(tempList.size() - j - 1, swapValue);
                }
            }
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
