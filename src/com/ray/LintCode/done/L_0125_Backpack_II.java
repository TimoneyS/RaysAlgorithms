package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      There are `n` items and a backpack with size `m`. Given array `A` representing the size of each item and array `V` representing the value of each item.
 *      
 *      What's the maximum value can you put into the backpack?
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 *      Output: 9
 *      Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9 
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 *      Output: 10
 *      Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10 
 *      ```
 *
 * 挑战：
 *      O(nm) memory is acceptable, can you do it in O(m) memory?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/backpack-ii/description
 * @date   2019-07-11 18:30:53
 */
public class L_0125_Backpack_II {

    static class Solution {
        
        public int backPackII(int m, int[] A, int[] V) {
            int[] mem = new int[m+1]; 
            
            for (int i = 0; i < A.length; i++) {
                for (int j = m; j >0; j--) {
                    if (j < A[i]) continue;
                    mem[j] = Math.max(mem[j], mem[j-A[i]] + V[i]);
                }
            }
            
            return mem[m];
        }
        
    }
    
    public static void main(String[] args) {
        
        int m = 10;
        int[] A = {2, 3, 8};
        int[] V = {4, 5, 8};
        
        Out.p(new Solution().backPackII(m, A, V));
        
    }

}
