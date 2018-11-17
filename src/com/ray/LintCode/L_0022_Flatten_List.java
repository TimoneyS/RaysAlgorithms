package com.ray.LintCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a list, each element in the list can be a list or integer.
 * flatten it into a simply list with integers.
 * <p>
 * Example
 * <p>
 * Given [1,2,[1,2]], return [1,2,1,2].<br>
 * Given [4,[3,[2,[1]]]], return [4,3,2,1].<br>
 * @author rays1
 *
 */
public class L_0022_Flatten_List {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer,
     *     // rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds,
     *     // if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds,
     *     // if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    static class Solution {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            // Write your code here
            LinkedList<Integer> rs = new LinkedList<>();            
            LinkedList<NestedInteger> stack = new LinkedList<>();
            
            for (NestedInteger nestedInteger : nestedList) {
                stack.push(nestedInteger);
            }
            
            while (stack.size() != 0) {
                NestedInteger ni = stack.pop();
                if (ni.isInteger()) {
                    rs.addFirst(ni.getInteger());
                } else {
                    for (NestedInteger nit : ni.getList())
                        stack.push(nit);
                }
            }
            return rs;
        }
    }
    
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    
}
