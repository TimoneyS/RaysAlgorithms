package com.ray.leetcode.resolved;

import com.ray.leetcode.util.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Flatten Nested List Iterator
 * -----------------------------------------------------------------------------
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example:
 *      Example 1
 *      Input: [[1,1],2,[1,1]]
 *      Output: [1,1,2,1,1]
 *      Explanation: By calling next repeatedly until hasNext returns false, 
 *                   the order of elements returned by next should be: [1,1,2,1,1].
 *      Example 2
 *      Input: [1,[4,[6]]]
 *      Output: [1,4,6]
 *      Explanation: By calling next repeatedly until hasNext returns false, 
 *                   the order of elements returned by next should be: [1,4,6].
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * @since   2020-03-12 22:41:46
 */
public class L0341_Flatten_Nested_List_Iterator {
    static class NestedIterator implements Iterator<Integer> {

        class Pair {
            List<NestedInteger> list;
            int index;
            public Pair(List<NestedInteger> list, int index) {
                super();
                this.list = list;
                this.index = index;
            }
            public boolean isValid() {
                return index < list.size();
            }
            public NestedInteger curr() {
                return list.get(index);
            }
        }

        Stack<Pair> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(new Pair(nestedList, 0));
            insureNext();
        }

        /**
         * 保证调用next时，栈顶的一定是数字
         */
        private void insureNext() {
            while (!stack.isEmpty()) {
                Pair p = stack.peek();
                NestedInteger ni;
                if (!p.isValid()) {
                    stack.pop();
                } else if ( !(ni = p.curr()).isInteger()) {
                    p.index ++;
                    stack.push(new Pair(ni.getList(), 0));
                } else {
                    break;
                }
            }
        }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
            Pair p = stack.peek();
            Integer rs = p.curr().getInteger();
            p.index ++;
            insureNext();
            return rs;
        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            return !stack.empty() && stack.peek().isValid();
        }
    }
    
    public static void main(String[] args) {
    }
}
