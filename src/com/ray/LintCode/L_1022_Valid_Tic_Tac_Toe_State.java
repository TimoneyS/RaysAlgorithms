package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   A Tic-Tac-Toe board is given as a string array `board`. Return `true` if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 *   
 *   The `board` is a 3 x 3 array, and consists of characters `' '`, `'X'`, and `'O'`.  The `' '` character represents an empty square.
 *   
 *   Here are the rules of Tic-Tac-Toe:
 *   
 *   * Players take turns placing characters into empty squares `' '`.
 *   * The first player always places `'X'` characters, while the second player always places `'O'` characters.
 *   * `'X'` and `'O'` characters are always placed into empty squares, never filled ones.
 *   * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 *   * The game also ends if all squares are non-empty.
 *   * No more moves can be played if the game is over.
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: board = ["O  ", "   ", "   "]
 *   Output: false
 *   Explanation: The first player always plays "X".
 *   ```
 *   
 *   **Example 2:**
 *   ```
 *   Input: board = ["XOX", " X ", "   "]
 *   Output: false
 *   Explanation: Players take turns making moves.
 *   ```
 *   
 *   **Example 3:**
 *   ```
 *   Input: board = ["XXX", "   ", "OOO"]
 *   Output: false
 *   ```
 *   
 *   **Example 4:**
 *   ```
 *   Input: board = ["XOX", "O O", "XOX"]
 *   Output: true
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-tic-tac-toe-state/description
 * @date   2019-07-03 17:36:40
 */
public class L_1022_Valid_Tic_Tac_Toe_State {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
