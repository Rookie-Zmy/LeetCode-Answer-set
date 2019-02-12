package com.code.leetcode;

import java.util.*;

public class LeetCode341FlattenNestedListIterator {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class SolidInteger implements NestedInteger {

        private boolean isInteger;
        private Integer integer;
        private List<NestedInteger> list;

        public SolidInteger(Integer x) {
            isInteger = true;
            integer = x;
        }

        public SolidInteger(List<NestedInteger> x) {
            isInteger = false;
            list = x;
        }

        @Override
        public boolean isInteger() {
            return isInteger;
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            if (isInteger) {
                return integer.toString();
            } else {
                return list.toString();
            }
        }
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<ListIterator> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            System.out.println(nestedList.toString());
            stack = new Stack<>();
            if (hasInteger(nestedList)) {
                stack.push(nestedList.listIterator());
            }
        }

        @Override
        public Integer next() {
            while (true) {
                if (stack.empty()) {
                    return null;
                }
                ListIterator<NestedInteger> temp = stack.peek();

                // 空列表的处理
                if (!temp.hasNext()) {
                    stack.pop();
                    continue;
                }

                NestedInteger nestedInteger = temp.next();
                if (!temp.hasNext()) {
                    stack.pop();
                }

                if (nestedInteger.isInteger()) {
                    return nestedInteger.getInteger();
                } else {
                    List tempList = nestedInteger.getList();
                    if (hasInteger(tempList)) {
                        stack.push(tempList.listIterator());
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            while (!stack.empty()) {
                ListIterator<NestedInteger> iterator = (ListIterator<NestedInteger>) stack.peek();
                if (!iterator.hasNext()) {
                    stack.pop();
                    continue;
                }
                NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()) {
                    iterator.previous();
                    return true;
                } else {
                    if (hasInteger(nestedInteger.getList())) {
                        iterator.previous();
                        return true;
                    }
                }
            }

            return !stack.empty();
        }

        private boolean hasInteger(List<NestedInteger> list) {
            ListIterator<NestedInteger> iterator = list.listIterator();
            while (iterator.hasNext()) {
                NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()) {
                    return true;
                } else {
                    if (hasInteger(nestedInteger.getList())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        LeetCode341FlattenNestedListIterator temp = new LeetCode341FlattenNestedListIterator();

        List<NestedInteger> list = new ArrayList<>(Arrays.asList(temp.new SolidInteger(new ArrayList<>())));
        NestedIterator iterator = temp.new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list = new ArrayList<>(
                Arrays.asList(
                        temp.new SolidInteger(1),
                        temp.new SolidInteger(
                                new ArrayList<>(Arrays.asList(temp.new SolidInteger(4),
                                        temp.new SolidInteger(new ArrayList<>(Arrays.asList(temp.new SolidInteger(6)))
                                        ))))
                ));
        iterator = temp.new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list = new ArrayList<>();
        iterator = temp.new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list = new ArrayList<>(
                Arrays.asList(
                        temp.new SolidInteger(new ArrayList<>(Arrays.asList(temp.new SolidInteger(1)))),
                        temp.new SolidInteger(
                                new ArrayList<>())
                ));
        iterator = temp.new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list = new ArrayList<>(
                Arrays.asList(
                        temp.new SolidInteger(
                                new ArrayList<>()),
                        temp.new SolidInteger(new ArrayList<>(Arrays.asList(temp.new SolidInteger(3))))
                        ));
        iterator = temp.new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
