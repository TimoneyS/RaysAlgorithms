package com.ray.LintCode.done;

import java.util.ArrayList;
import java.util.List;

import com.ray.io.Out;

/**
 * Description :
 *   You are playing the following Flip Game with your friend:
 *      Given a string that contains only these two characters: `+` and `-`,
 *      you and your friend take turns to flip two **consecutive** `"++"` into `"--"`. 
 *      
 *      The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *   
 *   Write a function to compute all possible states of the string after one valid move.
 *
 * Example :
 *   **Example1**
 *   
 *   ```
 *   Input:  s = "++++"
 *   Output: 
 *   [
 *     "--++",
 *     "+--+",
 *     "++--"
 *   ]
 *   ```
 *   
 *   **Example2**
 *   
 *   ```
 *   Input: s = "---+++-+++-+"
 *   Output: 
 *   [
 *   	"---+++-+---+",
 *   	"---+++---+-+",
 *   	"---+---+++-+",
 *   	"-----+-+++-+"
 *   ]
 *   
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/flip-game/description
 * @date   2019-07-03 17:34:21
 */
public class L_0914_Flip_Game {

    static class Solution {
    
        public List<String> generatePossibleNextMoves(String s) {
            List<String> rs = new ArrayList<>();
            char bak = ' ', c = ' ';
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '+' && bak == '+') {
                    rs.add(s.substring(0, i-1) + "--" + s.substring(i+1));
                }
                bak = c;
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        String s = "---+++-+++-+";
        
        Out.p(new Solution().generatePossibleNextMoves(s));
        
    }

}
