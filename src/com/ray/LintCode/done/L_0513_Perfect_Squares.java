package com.ray.LintCode.done;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a positive integer `n`, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to n.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 12
 *      Output: 3
 *      Explanation: 4 + 4 + 4
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 13
 *      Output: 2
 *      Explanation: 4 + 9
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/perfect-squares/description
 * @date   2019-07-11 18:33:44
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
