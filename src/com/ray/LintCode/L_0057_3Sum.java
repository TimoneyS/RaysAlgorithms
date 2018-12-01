package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 *<p>
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 *
 * @author rays1
 *
 */
public class L_0057_3Sum {

    static class Solution {
        
        /**
         * @param numbers: Give an array numbers of n integer
         * @return: Find all unique triplets in the array which gives the sum of zero.
         */
        public List<List<Integer>> threeSum(int[] numbers) {
            
         
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1};
        
        Out.p(new Solution().threeSum(numbers));
        
    }

}
