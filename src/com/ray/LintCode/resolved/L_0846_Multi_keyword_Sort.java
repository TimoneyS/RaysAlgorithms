package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 *
 * Given n students and their test scores, expressed as (student number, test scores), 
 * sort by test scores in descending order, if the test scores are the same, sort the student number in ascending order.
 *
 * @author rays1
 *
 */
public class L_0846_Multi_keyword_Sort {

    static class Solution {
    
        public int[][] multiSort(int[][] array) {
            Arrays.sort(array, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            return null;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
