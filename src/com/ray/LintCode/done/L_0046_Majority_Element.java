package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers, the majority number is the number that occurs `more than half` of the size of the array. Find it.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [1, 1, 1, 1, 2, 2, 2]
 *      Output: 1
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1, 1, 1, 2, 2, 2, 2]
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      O(_n_) time and O(_1_) extra space
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/majority-element/description
 * @date   2019-07-11 18:00:16
 */
public class L_0046_Majority_Element {

    static class Solution {
        /*
         * @param nums: a list of integers
         * @return: find a  majority number
         */
        public int majorityNumber(List<Integer> nums) {
            Integer num = null;
            int ct = 0;
            for (Integer i : nums) {
                if (ct == 0) num = i;
                if (i.equals(num)) ct ++;
                else ct --;
            }
            return num;
        }
        
    }
    
    public static void main(String[] args) {
        
        List<Integer> nums = Arrays.asList(new Integer[] {1,1,1,1,2,2,3});
        
        Out.p(new Solution().majorityNumber(nums));
    }

}
