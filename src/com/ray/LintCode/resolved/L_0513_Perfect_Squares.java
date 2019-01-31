package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给定一个正整数 n， 寻找最少的平方数之和为 n
 * 
 * 如:
 *      11 = 9 + 1 + 1
 *      13 = 9 + 4
 *
 * @author rays1
 *
 */
public class L_0513_Perfect_Squares {

    /**
     * 标准动态规划，按照 先用 根号n 试探，依次减少试探的值
     * @author rays1
     *
     */
    static class Solution {
    
        Map<Integer, Integer> mem;
        
        public int numSquares(int n) {
            mem = new HashMap<>();
            return helper(n);
        }
        
        int helper(int n) {
            
            Out.pf("helper %s\n", n);
            
            if (n == 0) return 0;
            if (n == 1) return 1;
            
            if (!mem.containsKey(n)) {
                int min = Integer.MAX_VALUE;
                for (int i = (int) Math.sqrt(n); i >= (int) Math.sqrt(n/2); i --) {
                    min = Math.min(min, helper(n - i*i));
                }
                mem.put(n, 1 + min);
            }
            return mem.get(n);
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        
        Out.p(new Solution().numSquares(n));
        
    }

}
