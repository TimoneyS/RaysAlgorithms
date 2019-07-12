package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array and two indexes, swap the integers on the two indices.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: `[1,2,3,4]` and index1 = `2`, index2 = `3`
 *      Output:The array will change to `[1,2,4,3]` after swapping. You don't need return anything, just swap the integers in-place.
 *      Explanation: You don't need return anything, just swap the integers in-place.
 *      ```
 *      **Example 2:**
 *      
 *      ```
 *      Input: `[1,2,2,2]` and index1 = `0`, index2 = `3`
 *      Output:The array will change to `[2,2,2,1]` after swapping. You don't need return anything, just swap the integers in-place.
 *      Explanation: You don't need return anything, just swap the integers in-place.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/swap-two-integers-in-array/description
 * @date   2019-07-11 18:33:29
 */
public class L_0484_Swap_Two_Integers_in_Array {

    static class Solution {
        public void swapIntegers(int[] A, int index1, int index2) {
            int t = A[index1];
            A[index1] = A[index2];
            A[index2] = t;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
