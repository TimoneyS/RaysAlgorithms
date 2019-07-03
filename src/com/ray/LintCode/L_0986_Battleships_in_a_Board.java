package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an 2D board, count how many battleships are in it. The battleships are represented with `'X'`s, empty slots are represented with `'.'`s. You may assume the following rules:
 *   * You receive a valid board, made of only battleships or empty slots.
 *   * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape `1xN` (1 row, N columns) or `Nx1` (N rows, 1 column), where N can be of any size.
 *   * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 *
 * Example :
 *   **Example1**
 *   ```
 *   Input:
 *   X..X
 *   ...X
 *   ...X
 *   Output: 2
 *   Explanation:
 *   In the above board there are 2 battleships.
 *   ```
 *   **Example2**
 *   ```
 *   Input:
 *   ...X
 *   XXXX
 *   ...X
 *   Explanation:
 *   This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 *   ```
 *
 * Challenge :
 *   Could you do it in **one-pass**, using only **O(1) extra memory** and **without modifying** the value of the board?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/battleships-in-a-board/description
 * @date   2019-07-03 17:35:40
 */
public class L_0986_Battleships_in_a_Board {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
