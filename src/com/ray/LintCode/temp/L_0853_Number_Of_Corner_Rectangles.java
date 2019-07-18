package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a grid with only 0 and 1, find the number of corner rectangles.
 *      
 *      Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input:
 *        [
 *          [1, 0, 0, 1, 0],
 *          [0, 0, 1, 0, 1],
 *          [0, 0, 0, 1, 0],
 *          [1, 0, 1, 0, 1]
 *        ]
 *      Output: 1
 *      Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input:
 *        [
 *          [1, 1, 1],
 *          [1, 1, 1],
 *          [1, 1, 1]
 *        ]
 *      Output: 9
 *      Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: [[1,1,1,1]]
 *      Output: 0
 *      Explanation: Rectangles must have four distinct corners.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/number-of-corner-rectangles/description
 * @date   2019-07-11 18:37:37
 */
public class L_0853_Number_Of_Corner_Rectangles {

    /**
     * 记住每个坐标的下一个 1 的横坐标和纵坐标
     * 
     * 然后对于每个是 的坐标，分别向右延申每个宽度
     *      对于每个宽度向下延申高度，如果能够组成正方形，则计数+1
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int countCornerRectangles(int[][] grid) {
            
            int n = grid.length, m = grid[0].length;
            int[][] nextCol = new int[n][m];
            int[][] nextRow = new int[n][m];
            
            
            for (int i = 0; i < n; i++) {
                int col = -1;
                for (int j = 0; j < m; j++) {
                    nextCol[i][j] = col;
                    if (grid[i][j] == 1) col = j; 
                }
            }
            
            for (int j = 0; j < m; j++) {
                int row = -1;
                for (int i = 0; i < n; i++) {
                    nextRow[i][j] = row;
                    if (grid[i][j] == 1) row = i; 
                }
            }
            
            int c = 0;
            for (int i = n-1; i >= 0; i--) {
                for (int j = m-1; j >= 0; j -- ) {
                    if (grid[i][j] == 1)
                        c += find(nextRow, nextCol, i, j);
                }
            }
            
            return c;
        }

        private int find(int[][] nextRow, int[][] nextCol, int rdi, int rdj) {
            int c = 0;
            int ldi = rdi;
            for (int ldj = nextCol[rdi][rdj]; ldj != rdj && ldj != -1; ldj = nextCol[rdi][ldj]) {
                
                int lui = nextRow[ldi][ldj];
                int rui = nextRow[rdi][rdj];
                
                while (lui != ldi && lui != -1 && rui != rdi && rui != -1) {
                    
                    if (lui == rui) {
                        c ++;
                        lui = nextRow[lui][ldj];
                        rui = nextRow[rui][rdj];
                    } else if (lui > rui) {
                        lui = nextRow[lui][ldj];
                    }  else {
                        rui = nextRow[rui][rdj];
                    }
                }
                
            }
            
            return c;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
