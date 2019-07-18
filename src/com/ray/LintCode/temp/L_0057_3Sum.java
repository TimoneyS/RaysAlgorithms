package com.ray.LintCode.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array *S* of n integers, are there elements *a*, *b*, *c* in *S* such that `a + b + c = 0`? Find all unique triplets in the array which gives the sum of zero.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[2,7,11,15]
 *      Output:[]
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input:[-1,0,1,2,-1,-4]
 *      Output:	[[-1, 0, 1],[-1, -1, 2]]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum/description
 * @date   2019-07-11 18:17:02
 */
public class L_0057_3Sum {

    static class Solution {
        
        /**
         * @param numbers: Give an array numbers of n integer
         * @return: Find all unique triplets in the array which gives the sum of zero.
         */
        public List<List<Integer>> threeSum(int[] numbers) {
            
            List<List<Integer>>   rs = new ArrayList<List<Integer>>();
            Map<Integer, Boolean> marked = new HashMap<Integer, Boolean>();
            
            for (int i = 0; i < numbers.length; i++) {
                if (marked.containsKey(numbers[i])) continue;
                
                twoSum(numbers, i+1, 0-numbers[i], marked, rs);
                
                marked.put(numbers[i], true);
            }
         
            return rs;
        }
        
        private void twoSum(int[] numbers, int start, int target, Map<Integer, Boolean> basemarked, List<List<Integer>> rs) {
            
            Map<Integer, Boolean> marked = new HashMap<Integer, Boolean>();
            Map<Integer, Integer> remain = new HashMap<>();
            
            
            for (int i = start; i < numbers.length; i++) {
                int num = numbers[i];
                
                if (marked.containsKey(num) || basemarked.containsKey(num)) continue;
                if (remain.containsKey(num)) {
                    int j = remain.get(num);
                    List<Integer> l = new ArrayList<Integer>(3);
                    l.add(numbers[start-1]);
                    l.add(numbers[i]);
                    l.add(numbers[j]);
                    Collections.sort(l);
                    marked.put(numbers[i], true);
                    marked.put(numbers[j], true);
                    
                    rs.add(l);
                }
                
                remain.put(target-num, i);
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] numbers = {-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
        
        Out.p(new Solution().threeSum(numbers));
        
    }

}
