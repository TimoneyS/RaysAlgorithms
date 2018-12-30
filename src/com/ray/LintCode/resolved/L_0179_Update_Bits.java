package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N start from i to j)
 *
 * @author rays1
 *
 */
public class L_0179_Update_Bits {
    static class Solution {
        public int updateBits(int n, int m, int i, int j) {
            
            int cover = -1;
            cover &= (-1 << j+1);
            cover |= ((1 << i) - 1);
            
            m = m << i;
            n = ((n & cover) | m);
            
            return n;
        }
    }
    
    public static void printBinary(int m) {
        Out.p(Integer.toBinaryString(m));
    }
    
    public static void main(String[] args) {
        
        int n = 1024, m = 21, i = 2, j = 6;
        
        printBinary(n);
        printBinary(m);
        
        int rs = new Solution().updateBits(n, m, i, j);
        
        printBinary(rs);
    }
    
}
