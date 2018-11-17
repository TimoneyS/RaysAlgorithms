package com.ray.LintCode;

import java.util.ArrayList;
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
            ArrayList<Integer> rs = new ArrayList<>();            
            ArrayList<NestedInteger> al = new ArrayList<>();

            al.addAll(nestedList);
            
            while (al.size() > 0) {
                NestedInteger ni = al.remove(al.size()-1);
                if (ni.isInteger()) {
                    rs.add(ni.getInteger());
                } else {
                    al.addAll(ni.getList());
                }
            }
            
            ArrayList<Integer> rsN = new ArrayList<>(al.size());
            
            for (int i = rs.size()-1; i >= 0; i--) {
                rsN.add(rs.get(i));
            }
            
            return rsN;
        }
    }
    
    /**
     * 用 ArrayList 比用 LinkedList 快
     * @author rays1
     *
     */
    static class SolutionR {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            // Write your code here
            List<Integer> rs = new ArrayList<>();
            flatten(rs, nestedList);
            return rs;
        }

        public void flatten(List<Integer> rs, List<NestedInteger> nestedList) {

            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger())
                    rs.add(nestedInteger.getInteger());
                else
                    flatten(rs, nestedInteger.getList());
            }
        }
    }
    
    // n r
    static class Solution2 {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            boolean isFlat = true;
            List<NestedInteger> ls = nestedList;
            while (isFlat) {
                isFlat = false;
                List<NestedInteger> newLs = new ArrayList<>();
                for (NestedInteger ni : ls) {
                    if (ni.isInteger()) {
                        newLs.add(ni);
                    } else {
                        newLs.addAll(ni.getList());
                        isFlat = true;
                    }
                }
                ls = newLs;
            }
            List<Integer> r = new ArrayList<>();
            for (NestedInteger ni : ls) {
                r.add(ni.getInteger());
            }
            return r;
        }
    }
    
    static class SolutionR2 {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            // Write your code here
            List<Integer> result = new ArrayList<Integer>();
            for (NestedInteger ele : nestedList)
                if (ele.isInteger())
                    result.add(ele.getInteger());
                else
                    result.addAll(flatten(ele.getList()));
            return result;
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
        
        Timer.CLICK();
        build(ni, sb.toString(), 1);
        Timer.CLICK();
        new Solution().flatten(ni.innerList);
        Timer.CLICK();
        new SolutionR().flatten(ni.innerList);
        Timer.CLICK();
        new Solution2().flatten(ni.innerList);
        Timer.CLICK();
        new SolutionR2().flatten(ni.innerList);
        Timer.STOP();
        
//        Out.p(li);
        
    }
    
}
