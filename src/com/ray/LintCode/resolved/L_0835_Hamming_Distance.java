package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 *
 * @author rays1
 *
 */
public class L_0835_Hamming_Distance {

    static class Solution {
    
        public int hammingDistance(int x, int y) {
            int d = 0;
            while (x+y != 0) {
                if ((x % 2) != (y % 2)) d++;
                x /= 2;
                y /= 2;
            }
            return d;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution().hammingDistance(1, 4));
        
    }

}
