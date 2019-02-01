package com.ray.LintCode.util;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
        
   private int num;
   private List<NestedInteger> innerList;
    
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
    
    public static NestedInteger build(String s) {
        NestedInteger ni = new NestedInteger();
        build(ni, s, 1);
        return ni;
    }
    
    private static int build(NestedInteger ni, String s, int start ) {
        ni.innerList = new ArrayList<NestedInteger>();
        
        while (start < s.length()) {
            char c = s.charAt(start);
            
            if (c == '[') {
                NestedInteger niT = new NestedInteger();
                start = build(niT, s, start + 1);
                ni.getList().add(niT);
            } else if (c == ',') {
                start ++;
            } else if (c == ']' ) {
                start ++;
                break;
            } else if (c <= '9' && c >= '0') {
                int num = c - '0';
                while (start < s.length()) {
                    char cc = s.charAt(start + 1);
                    if (cc <= '9' && cc >= '0') {
                        num = num * 10 + (cc-'0');
                        start += 1;
                    } else {
                        break;
                    }
                }
                start += 1;
                NestedInteger nit = new NestedInteger();
                nit.num = num;
                ni.innerList.add(nit);
            }
            
        }
        
        return start;
    }
    
}