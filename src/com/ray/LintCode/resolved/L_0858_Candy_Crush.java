package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies.
 * A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game
 * following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
 *
 *      1. If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time
 *         - these positions become empty.
 *      
 *      2. After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will
 *         drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
 *       
 *      3. After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
 *      
 *      4. If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
 *         You need to perform the above rules until the board becomes stable, then return the current board.
 *
 * 实现一个三消游戏，可以消除上下左右连成三个以上的元素。一轮消除完毕后，空出来的地方上方的元素会下落，占用这些空地。
 * 下落之后可能触发二轮消除，重复直到面板处于一个稳定的状态。
 *
 * @author rays1
 * @url    https://www.lintcode.com/problem/candy-crush/description
 */
public class L_0858_Candy_Crush {

    static class Solution {
    
        public int[][] candyCrush(int[][] board) {
            
            int n = board.length, m = board[0].length;
            
            boolean[][] marked = new boolean[n][m];
            while (markedToCrush(board, marked, n, m)) {
                crush(board, marked, n, m);
                marked = new boolean[n][m];
            }
            
            return board;
        }

        private void crush(int[][] board, boolean[][] marked, int n, int m) {
            
            for (int j = 0; j < m; j++) {
                int down = n-1, up = n-1;
                while (down >= 0) {
                    if (up >= 0) {
                        if (!marked[up][j]) {
                            board[down--][j] = board[up][j];
                        }
                        up --;
                    } else {
                        board[down--][j] = 0;
                    }
                }
            }
            
        }

        private boolean markedToCrush(int[][] board, boolean[][] marked, int n, int m) {
            
            boolean flag  = false;
            
            for (int j = 0; j < m; j++) {
                int c = 1, prev = 0;
                for (int i = 0; i < n; i++) {
                    if (board[i][j] == prev) {
                        if (prev != 0) c ++;
                        if (c == 3) {
                            flag =  true;
                            marked[i-2][j] = true;
                            marked[i-1][j] = true;
                            marked[i][j] = true;
                        } if (c > 3) {
                            flag =  true;
                            marked[i][j] = true;
                        }
                    } else {
                        prev = board[i][j];
                        c = 1;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                int c = 1, prev = -1;
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == prev) {
                        if (prev != 0) c ++;
                        if (c == 3) {
                            flag =  true;
                            for (int k = 0; k < 3; k++)
                                marked[i][j-k] = true;
                        } if (c > 3) {
                            flag =  true;
                            marked[i][j] = true;
                        }
                    } else {
                        prev = board[i][j];
                        c = 1;
                    }
                }
                
            }
            
            return flag;
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int[][] board = {
                { 0, 0, 0, 0, 5 }, 
                { 2, 0, 0, 3, 3 }, 
                { 2, 4, 5, 2, 4 }, 
                { 2, 2, 4, 5, 5 }, 
                { 5, 2, 3, 3, 5 }
            };
        
        Out.p(board, "%s ");
        Out.sep();
        Out.p(new Solution().candyCrush(board), "%s ");
        
    }

}
