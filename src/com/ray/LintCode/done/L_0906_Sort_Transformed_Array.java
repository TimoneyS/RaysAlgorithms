package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a **sorted** array of integers nums and integer values a, b and c. Apply a quadratic function of the form $f(x)=ax^2+bx+c$ to each element $x$ in the array.
 *      
 *      The returned array must be in **sorted order**.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5
 *      Output: [3, 9, 15, 33]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 *      Output: [-23, -5, 1, 7]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-transformed-array/description
 * @date   2019-07-11 18:38:31
 */
public class L_0906_Sort_Transformed_Array {

    static class Solution {
        
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = a*nums[i]*nums[i] + b*nums[i] + c;
            }
            Arrays.sort(nums);
            return nums;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
