package com.ray.LintCode;

import com.ray.io.Out;

/**
 * There are n items and a backpack with size m. Given array A representing the size of each item and array V 
 * representing the value of each item.
 * What's the maximum value can you put into the backpack?
 * 
 * * * * *
 * 背包问题：m大小的背包，能够获取最大的物品价值
 *
 * @author rays1
 * @url    
 * @date   2019-06-28 14:51:48
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
