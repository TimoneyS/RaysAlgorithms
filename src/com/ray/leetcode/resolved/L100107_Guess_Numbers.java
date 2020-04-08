package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Guess Numbers
 * -----------------------------------------------------------------------------
 * English description is not available for the problem. Please switch to Chinese.
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/guess-numbers/
 * @since   2020-04-08 22:05:34
 */
public class L100107_Guess_Numbers {
    static class Solution {
        public int game(int[] guess, int[] answer) {
            int count =0;
            for(int i=0;i<3;i++){
                if(guess[i] == answer[i]){
                    count += 1;
                }
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
