package com.ray.LintCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.io.In;
import com.ray.util.Timer;

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
            
            stack.addAll(nestedList);
            
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
    
    static class NestedInteger {
        
        int num;
        List<NestedInteger> innerList;
        
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger() {
            return innerList == null;
        }
        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return num;
        }
        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return innerList;
        }
        
    }
    
    public static int build(NestedInteger ni, String s, int cursor ) {
        ni.innerList = new LinkedList<NestedInteger>();
        
        while (cursor < s.length()) {
            char c = s.charAt(cursor);
            
            if (c == '[') {
                NestedInteger niT = new NestedInteger();
                cursor = build(niT, s, cursor + 1);
                ni.innerList.add(niT);
            } else if (c == ',') {
                cursor ++;
            } else if (c == ']' ) {
                cursor ++;
                break;
            } else if (c <= 57 && c >= 48) {
                int num = c - 48;
                while (cursor < s.length()) {
                    char cc = s.charAt(cursor + 1);
                    if (cc <= 57 && cc >= 48) {
                        num = num * 10 + (cc-48);
                        cursor += 1;
                    } else {
                        break;
                    }
                }
                cursor += 1;
                NestedInteger nit = new NestedInteger();
                nit.num = num;
                ni.innerList.add(nit);
            }
            
        }
        
        return cursor;
        
    }
    
    public static void main(String[] args) {
        Scanner sc = In.getClassPathScanner(L_0022_Flatten_List.class, "L_0022_Flatten_List.in");
        StringBuilder sb = new StringBuilder();
        
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        
        NestedInteger ni = new NestedInteger();
        
        Timer t = Timer.create();
        
        t.click();
        build(ni, sb.toString(), 1);
        t.click();
        new Solution().flatten(ni.innerList);
        t.stop();
        
//        Out.p(li);
        
    }
    
}
