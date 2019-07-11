package com.ray.LintCode.done;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      扔 n 个筛子，所有筛子之和为 S。给定一个数字 n，寻找所有的可能的S及其概率。
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 1
 *      Output: [[1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]]
 *      Explanation: Throw a dice, the sum of the numbers facing up may be 1, 2, 3, 4, 5, 6, and the probability of each result is 0.17.
 *      ```
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 2
 *      Output: [[2,0.03],[3,0.06],[4,0.08],[5,0.11],[6,0.14],[7,0.17],[8,0.14],[9,0.11],[10,0.08],[11,0.06],[12,0.03]]
 *      Explanation: Throw two dices, the sum of the numbers facing up may be in [2,12], and the probability of each result is different.
 *      ```
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/dices-sum/description
 * @date   2019-07-10 22:51:18
 */
public class L_0020_Dices_Sum {

    /**
     * 所有可能的筛子和在 n ~ 6n 之间
     * 设 bp[n][m] 表示投掷 n 个筛子，和为 m 的概率。
     * 
     * 概率可以分解为 n-1个筛子掷出 m-1 一个筛子掷出 1 的概率
     *              n-1个筛子掷出 m-2 一个筛子掷出 2 的概率
     *              n-1个筛子掷出 m-3 一个筛子掷出 3 的概率
     *              ...
     * 一个筛子掷出任意的概率都是 1 / 6
     * 因此 bp[n][m] = bp[n-1][m-1]/6 + bp[n-1][m-2]/6 + ...               
     *              
     * @author rays1
     *
     */
    static class Solution {
    
        public List<Map.Entry<Integer, Double>> dicesSum(int n) {
            
            int m = n * 6;
            double[][] bp = new double[n+1][m+1];
            
            for (int k = 1; k <= 6; k++) {
                bp[1][k] = (1d / 6d);
            }
            
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= i * 6; j++) {
                    for (int k = 1; k <= 6; k++) {
                        if (j > k) {
                            bp[i][j] += bp[i - 1][j - k] / 6;
                        }
                    }
                }
            }
            
            List<Map.Entry<Integer, Double>> rs = new ArrayList<>();
            for (int i = n; i <= m; i++) {
                rs.add(new AbstractMap.SimpleEntry<>(i, bp[n][i]));
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 2;
        
        Out.p(new Solution().dicesSum(n));
        
    }

}
