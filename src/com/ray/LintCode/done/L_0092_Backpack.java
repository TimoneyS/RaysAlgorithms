package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      背包问题，n个物体，重量为A[i]
 *      背包大小为m
 *      求背包可以装载的最大重量
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [3,4,8,5], backpack size=10
 *      	Output:  9
 *      
 *      Example 2:
 *      	Input:  [2,3,5,7], backpack size=12
 *      	Output:  12
 *      	
 *      ```
 *
 * 挑战：
 *      O(n x m) time and O(m) memory.
 *      
 *      O(n x m) memory is also acceptable if you do not know how to optimize memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @link   https://www.lintcode.cn/problem/backpack/description
 * @since  2019-07-11 18:30:07
 */
public class L_0092_Backpack {
    static class Solution {
        public int backPack(int m, int[] A) {
            int[] mem = new int[m+1];    
            for (int p : A) {
                for (int i = m; i >= p; i--) {
                    mem[i] = Math.max(mem[i], mem[i-p] + p);
                }
            }
            return mem[m];
        }
    }

    public static void main(String[] args) {
        int[] A = {2,4,7,5};
        int m = 10;
        Out.p(new Solution().backPack(m, A));
    }
}