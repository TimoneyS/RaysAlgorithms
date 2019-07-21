package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an `n x n` matrix of `positive` and `negative` integers, find the submatrix with the largest possible sum.
 *
 * 用例：
 *      **用例1**
 *      输入:  
 *      matrix = [
 *          [ 1, 3, -1],
 *          [ 2, 3, -2],
 *          [-1,-2, -3]
 *      ]
 *      输出: 9
 *      解释:
 *      the submatrix with the largest possible sum is:
 *      [
 *          [1,3],
 *          [2,3]
 *      ]
 *      
 *      **用例2**
 *      输入:  
 *      matrix = [
 *          [1,1,1],
 *          [1,1,1],
 *          [1,1,1]
 *      ]
 *      输出: 9
 *      解释:
 *      the submatrix with the largest possible sum is:
 *      [
 *          [1,1,1],
 *          [1,1,1],
 *          [1,1,1]
 *      ]
 *      
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/maximum-submatrix/description
 * @date   2019-07-20 12:07:06
 */
public class L_0944_Maximum_Submatrix {

    /**
     * 参考 L_0041_Maximum_Subarray
     * 
     * 
     * 可以将数组的若干行，认为是一行的所有元素，这这若干行使用一维数组的算法即可。
     * 
     * 所有可能的行的组合是 O(m^2)
     * 每一行的复杂度是 O(n)
     * 
     * 总体的复杂度为 O(n^2 * m) 或 O(m^2 * n)
     * 若行列的长度差距较大可以调整算法的方向。 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int maxSubmatrix(int[][] matrix) {
            
            int m = matrix == null ? 0 : matrix.length;
            int n = m == 0 ? 0 : matrix[0].length;
            
            int[][] colSum = new int[m][n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    colSum[i][j] = (i > 0 ? colSum[i-1][j] : 0) + matrix[i][j];
                }
            }
            
            int rs = 0;
            for (int i = 0; i < m; i++) {
                for (int j = i; j < m; j++) {
                    int max = Integer.MIN_VALUE, s = 0;
                    for (int k = 0; k < n; k++) {
                        max = Math.max((s = Math.max(0, s) + colSum[j][k] - (i > 0 ? colSum[i-1][k] : 0)), max);
                    }
                    rs = Math.max(max, rs);
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {
                { 1, 3, -1},
                { 2, 3, -2},
                {-1,-2, -3},
        };
        Out.p(new Solution().maxSubmatrix(matrix));
        
    }

}
