package com.ray.LintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * Given an array S of n integers,
 *  are there elements a, b, c, and d in S such that a + b + c + d = target?
 *  
 *  Find all unique quadruplets in the array which gives the sum of target.
 *  <Example>
 *   Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
 *      (-1, 0, 0, 1)
 *      (-2, -1, 1, 2)
 *      (-2, 0, 0, 2)
 * @author rays1
 *
 */
public class L_0058_4Sum {

    
    static class Solution {
    
        /**
         * @param numbers: Give an array
         * @param target: An integer
         * @return: Find all unique quadruplets in the array which gives the sum of zero
         */
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            List<List<Integer>>   rs = new ArrayList<List<Integer>>();
            
            Map<Integer, Boolean> fourMarked = new HashMap<Integer, Boolean>();
            for (int i = 0; i < numbers.length; i++) {
                if (fourMarked.containsKey(numbers[i])) continue;
                
                threeSum(numbers, i+1, target-numbers[i], numbers[i], fourMarked, rs);
                
                fourMarked.put(numbers[i], true);
            }
            
            return rs;
        }
        
        public List<List<Integer>> threeSum(int[] numbers, int start, int target, int fourBase, Map<Integer, Boolean> fourMarked,
                List<List<Integer>> rs) {
        
            Map<Integer, Boolean> threeMarked = new HashMap<Integer, Boolean>();
            
            for (int i = start; i < numbers.length; i++) {
                if (threeMarked.containsKey(numbers[i])) continue;
                if (fourMarked.containsKey(numbers[i])) continue;
                
                twoSum(numbers, i+1, target-numbers[i], fourBase, numbers[i], fourMarked, threeMarked, rs);
                
                threeMarked.put(numbers[i], true);
            }
         
            return rs;
        }
    
        private List<List<Integer>> twoSum(int[] numbers, int start, int target, 
                int fourBase,int threeBase,
                Map<Integer, Boolean> fourMarked, Map<Integer, Boolean> threeMarked, List<List<Integer>> rs) {
            
            Map<Integer, Boolean> marked = new HashMap<Integer, Boolean>();
            Map<Integer, Integer> remain = new HashMap<>();
            
            for (int i = start; i < numbers.length; i++) {
                int num = numbers[i];
                
                if (marked.containsKey(num)) continue;
                if (fourMarked.containsKey(num)) continue;
                if (threeMarked.containsKey(num)) continue;
                
                if (remain.containsKey(num)) {
                    int j = remain.get(num);
                    
                    List<Integer> l = new ArrayList<Integer>(3);
                    l.add(fourBase);
                    l.add(threeBase);
                    l.add(numbers[i]);
                    l.add(numbers[j]);
                    
                    Collections.sort(l);
                    
                    marked.put(numbers[i], true);
                    marked.put(numbers[j], true);
                    
                    rs.add(l);
                }
                
                remain.put(target-num, i);
                
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {1, 0, -1, 0, -2, 2};
        int target = 0;
        
        Out.p(new Solution().fourSum(numbers, target));
        
    }
    
}
