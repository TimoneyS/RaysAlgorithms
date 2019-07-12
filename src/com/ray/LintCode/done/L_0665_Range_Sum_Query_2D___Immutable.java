package com.ray.LintCode.done;

/**
 * 描述：
 *      Given a 2D matrix, find the sum of the elements inside the rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input:
 *      [[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]
 *      sumRegion(2, 1, 4, 3)
 *      sumRegion(1, 1, 2, 2)
 *      sumRegion(1, 2, 2, 4)
 *      Output:
 *      8
 *      11
 *      12
 *      Explanation:
 *      Given matrix = 
 *      [
 *        [3, 0, 1, 4, 2],
 *        [5, 6, 3, 2, 1],
 *        [1, 2, 0, 1, 5],
 *        [4, 1, 0, 1, 7],
 *        [1, 0, 3, 0, 5]
 *      ]
 *      sumRegion(2, 1, 4, 3) = 2 + 0 + 1 + 1 + 0 + 1 + 0 + 3 + 0 = 8
 *      sumRegion(1, 1, 2, 2) = 6 + 3 + 2 + 0 = 11
 *      sumRegion(1, 2, 2, 4) = 3 + 2 + 1 + 0 + 1 + 5 = 12
 *      ```
 *      **Example2**
 *      ```
 *      Input:
 *      [[3,0],[5,6]]
 *      sumRegion(0, 0, 0, 1)
 *      sumRegion(0, 0, 1, 1)
 *      Output:
 *      3
 *      14
 *      Explanation:
 *      Given matrix = 
 *      [
 *        [3, 0],
 *        [5, 6]
 *      ]
 *      sumRegion(0, 0, 0, 1) = 3 + 0 = 3
 *      sumRegion(0, 0, 1, 1) = 3 + 0 + 5 + 6 = 14
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-sum-query-2d-immutable/description
 * @date   2019-07-11 18:35:16
 */
public class L_0665_Range_Sum_Query_2D___Immutable {

    /**
     * 比如数组就范围之和，先求出每一段之和 S(n) 则 范围之和就是 S(n1) - S(n2)
     * 二维数组同理，只是需要做一些变换。
     * 
     * @author rays1
     *
     */
    static class NumMatrix {

        int[][] inner;
        int m, n;
        
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            inner = new int[m][n];
            
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    int l = j == 0 ? 0 : inner[i][j-1];
                    int u = i == 0 ? 0 : inner[i-1][j];
                    int lu = i == 0 || j == 0 ? 0 : inner[i-1][j-1];
                    inner[i][j] = l + u + matrix[i][j] - lu;
                }
            }
            
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int l = col1 == 0 ? 0 : inner[row2][col1-1]; 
            int u = row1 == 0 ? 0 : inner[row1-1][col2];             
            int lu = col1 == 0 || row1 == 0 ? 0 : inner[row1-1][col1-1];
            return inner[row2][col2] - l - u + lu;
        }
        
    }
    
    public static void main(String[] args) {
        
        
    }

}
