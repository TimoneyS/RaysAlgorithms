package com.ray.LintCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Throw *n* dices, the sum of the dices' faces is *S*. Given *n*, find the all possible value of *S* along with its probability.
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
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/dices-sum/description
 * @date   2019-07-10 22:51:18
 */
public class L_0020_Dices_Sum {

    static class Solution {
    
        public List<Map.Entry<Integer, Double>> dicesSum(int n) {
            // Write your code here
            // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
            // to create the pair
            
            int m = n * 6;
            
            double[][] bp = new double[n+1][m+1];
            bp[1][1] = bp[1][2] = bp[1][3] = bp[1][4] = bp[1][5] = bp[1][6] = (1d/6d);
            
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= i*6; j++) {
                    bp[i][j] = bp[i - 1][j - 1] / 6;
                    if (j > 6) bp[i][j] += bp[i - 1][j - 6] / 6;
                    if (j > 5) bp[i][j] += bp[i - 1][j - 5] / 6;
                    if (j > 4) bp[i][j] += bp[i - 1][j - 4] / 6;
                    if (j > 3) bp[i][j] += bp[i - 1][j - 3] / 6;
                    if (j > 2) bp[i][j] += bp[i - 1][j - 2] / 6;
                }
            }
            
            Map<Integer, Double> map = new HashMap<>();
            
            for (int i = n; i <= m; i++) {
                map.put(i, bp[n][i]);
            }
            
            return new LinkedList<>(map.entrySet());
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
