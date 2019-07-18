package com.ray.LintCode.temp;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of `non-negative` integers. Our task is to find minimum number of elements such that their sum should be greater than the sum of rest of the elements of the array.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: nums = [3, 1, 7, 1], 
 *      Output: 1
 *      ```
 *      Example 2:
 *      ```
 *      Input: nums = [2, 1, 2], 
 *      Output: 2
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/smallest-subset/description
 * @date   2019-07-11 18:36:06
 */
public class L_0761_Smallest_Subset {

    static class Solution {
    
        public int minElements(int[] arr) {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            int c = arr.length-1, t = 0;
            while (c >= 0 && t * 2 <= sum) {
                t += arr[c--];
            }
            
            return arr.length-c-1;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
