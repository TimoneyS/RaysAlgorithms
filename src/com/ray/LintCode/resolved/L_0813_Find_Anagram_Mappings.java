package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 *
 * Given two lists A and B, and B is an anagram of A. 
 * B is an anagram of A means B is made by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 *
 * @author rays1
 *
 */
public class L_0813_Find_Anagram_Mappings {

    /**
     * 两个数组 A, B
     * 
     * 寻找中间数组，对于 P[i] = j 有 A[i] = B[j]
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] anagramMappings(int[] A, int[] B) {
            
            int[] rs = new int[A.length];
            
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                map.put (B[i], i);
            }
            for (int i = 0; i < A.length; i++) {
                rs[i] = map.get (A[i]);
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
