package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      There is a fence with `n` posts, each post can be painted with one of the `k` colors.
 *      You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *      Return the total number of ways you can paint the fence.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: n=3, k=2  
 *      Output: 6
 *      Explanation:
 *                post 1,   post 2, post 3
 *          way1    0         0       1 
 *          way2    0         1       0
 *          way3    0         1       1
 *          way4    1         0       0
 *          way5    1         0       1
 *          way6    1         1       0
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input: n=2, k=2  
 *      Output: 4
 *      Explanation:
 *                post 1,   post 2
 *          way1    0         0       
 *          way2    0         1            
 *          way3    1         0          
 *          way4    1         1       
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/paint-fence/description
 * @date   2019-07-11 18:33:45
 */
public class L_0514_Paint_Fence {


    /**
     * 设 前 i 根柱子有 Si 种涂色的方法
     * 
     * 计算第i个柱子时，有两种情况
     *      1. 该柱子和第 i-1 个柱子颜色相同
     *          
     *          
     *      2. 该柱子和第 i-1 个柱子颜色不同
     *          

     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int numWays(int n, int k) {
            
            if (n == 1) {
                return k;
            }
            
            int[] mem = new int[n+1];
            
            mem[1] = k;
            mem[2] = k*k;
            for (int i = 3; i <= n; i++) {
                mem[i] = (k-1) * (mem[i-1] + mem[i-2]);
            }

            Out.p(mem);
            
            return mem[n];
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 2;
        int k = 1;
        
        Out.p(new Solution().numWays(n, k));
        
    }

}
