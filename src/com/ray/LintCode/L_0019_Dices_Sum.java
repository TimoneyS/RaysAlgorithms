package com.ray.LintCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ray.io.Out;

/**
 * Throw n dices, the sum of the dices' faces is S.
 * Given n, find the all possible value of S along with its probability.
 * <p>
 * Example
 * <p>
 * Given n = 1, return [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]].
 * 
 * @author rays1
 *
 */
public class L_0019_Dices_Sum {
    
    static class Solution {
        /**
         * @param n an integer
         * @return a list of Map.Entry<sum, probability>
         */
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
        
        
        for (Map.Entry<Integer, Double> e : new Solution().dicesSum(2)) {
            Out.p(e);
        }
        
    }
    
}
