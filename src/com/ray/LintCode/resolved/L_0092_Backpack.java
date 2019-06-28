package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * 
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11,
 *  we can select [2, 3, 5], so that the max size we can fill this backpack is 10. 
 * If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
 * <p>
 *  背包问题
 *
 * @author rays1
 *
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
 