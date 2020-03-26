package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Available Captures for Rook
 * -----------------------------------------------------------------------------
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 *
 * Example:
 *      Example 1
 *      Input: [[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,R,.,.,.,p],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.]]
 *      Output: 3
 *      Explanation: 
 *      In this example the rook is able to capture all the pawns.
 *      Example 2
 *      Input: [[.,.,.,.,.,.,.,.],[.,p,p,p,p,p,.,.],[.,p,p,B,p,p,.,.],[.,p,B,R,B,p,.,.],[.,p,p,B,p,p,.,.],[.,p,p,p,p,p,.,.],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.]]
 *      Output: 0
 *      Explanation: 
 *      Bishops are blocking the rook to capture any pawn.
 *      Example 3
 *      Input: [[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,p,.,.,.,.],[p,p,.,R,.,p,B,.],[.,.,.,.,.,.,.,.],[.,.,.,B,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,.,.,.,.,.]]
 *      Output: 3
 *      Explanation: 
 *      The rook can capture the pawns at positions b5, d6 and f5.
 *      Note:
 *      	board.length == board[i].length == 8
 *      	board[i][j] is either 'R', '.', 'B', or 'p'
 *      	There is exactly one cell with board[i][j] == 'R'
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/available-captures-for-rook/
 * @since   2020-03-27 00:11:29
 */
public class L1041_Available_Captures_for_Rook {
    static class Solution {
        public int numRookCaptures(char[][] board) {
            int rs = 0;
            int x = -1, y = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 'R') {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }

            for (int[] dir : new int[][]{{1, 0},{0, 1},{-1, 0},{0, -1}}) {
                for (int i = 1; i < 8; i++) {
                    if (x + i * dir[0] < 0 || x + i * dir[0] >= 8 ||
                            y + i * dir[1] < 0 || y + i * dir[1] >= 8 ||
                            board[x + i * dir[0]][y + i * dir[1]] == 'B'
                    ) {
                        break;
                    }
                    if(board[x + i * dir[0]][y + i * dir[1]] == 'p') {
                        rs ++;
                        break;
                    }
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
