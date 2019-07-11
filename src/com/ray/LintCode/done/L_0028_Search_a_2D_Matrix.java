package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      在 m*n 的矩阵中搜索值，矩阵的属性如下：
 *          每一行的整数时升序排列
 *          每一行的第一个数字，大于上一行的前一个数字
 *
 * 用例：
 *      Example 1:
 *      	Input:  [
 *          [1, 3, 5, 7],
 *          [10, 11, 16, 20],
 *          [23, 30, 34, 50]
 *      ],3
 *      	Output: true
 *      	
 *      	Explanation: 
 *      	return true if included.
 *      ```
 *
 * 挑战：
 *      O(log(n) + log(m)) time
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-a-2d-matrix/description
 * @date   2019-07-10 22:57:58
 */
public class L_0028_Search_a_2D_Matrix {

    /**
     * 将二维坐标转换为一位坐标，然后使用二分搜索
     * @author rays1
     *
     */
    static class Solution {
        
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0) return false;
            
            int col = matrix[0].length;
            
            int l = 0;
            int r = row * col - 1;
            
            while (l <= r) {
                int mid = (l + r) / 2;
                int c = Integer.compare(target, matrix[mid/col][mid % col]);
                if (c == 0) return true;
                if (c > 0) l = mid + 1;
                else       r = mid - 1;
            }
            
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        int target = 11;
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        
        Out.p(new Solution().searchMatrix(matrix, target));
        
    }

}
