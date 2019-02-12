package com.code.leetcode;


import java.util.*;

public class LeetCode173BinarySearchTreeIterator {
    public static void main(String args[]){
        LeetCode173BinarySearchTreeIterator temp = new LeetCode173BinarySearchTreeIterator();
        TreeNode head = temp.new TreeNode(7);
        head.left = temp.new TreeNode(3);
        head.right = temp.new TreeNode(15);
        head.right.left = temp.new TreeNode(9);
        head.right.right = temp.new TreeNode(20);
        BSTIterator iterator = temp.new BSTIterator(head);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

    class BSTIterator {
        private WrapTreeNode head;
        private WrapTreeNode cursor;

        public BSTIterator(TreeNode root) {
            WrapTreeNode nRoot = new WrapTreeNode(root);
            if (root == null) {
                return;
            }
            cursor = null;
            Stack<WrapTreeNode> stack = new Stack<>();
            // set用来进行标记该节点是否已经进行过处理
            Set<WrapTreeNode> set = new HashSet<>();
            stack.push(nRoot);
            while (!stack.empty()) {
                WrapTreeNode temp = stack.pop();
                if (set.contains(temp)) {
                    if (head == null) {
                        head = temp;
                        cursor = temp;
                    } else {
                        cursor.next = temp;
                        cursor = cursor.next;
                    }
                    continue;
                } else {
                    set.add(temp);
                }
                // 交换push顺序,即可分别实现先序、中序、后序
                if (temp.val.right != null) {
                    stack.push(new WrapTreeNode(temp.val.right));
                }
                stack.push(temp);
                if (temp.val.left != null) {
                    stack.push(new WrapTreeNode(temp.val.left));
                }
            }
            cursor = head;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int ans = cursor.val.val;
            cursor = cursor.next;
            return ans;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return cursor != null;
        }

        private class WrapTreeNode {
            // 当前节点
            TreeNode val;
            // 下一个节点
            WrapTreeNode next;

            WrapTreeNode(TreeNode node) {
                val = node;
            }
        }
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
