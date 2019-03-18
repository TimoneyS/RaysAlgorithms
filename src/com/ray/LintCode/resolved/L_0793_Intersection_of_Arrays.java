package com.ray.LintCode.resolved;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * Give a number of arrays, find their intersection, and output their intersection size.
 *
 * @author rays1
 *
 */
public class L_0793_Intersection_of_Arrays {

    /**
     * 偷懒使用 set
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int intersectionOfArrays(int[][] arrs) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i : arrs[0]) set1.add(i);
            for (int i = 1; i < arrs.length; i++) {
                for (int n : arrs[i]) {
                    if (set1.contains(n)) set2.add(n);
                }
                set1 = set2;
                set2 = new HashSet<>();
            }
            
            return set1.size();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
