package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * A = [2,3,1,1,4], return true. 
 * A = [3,2,1,0,4], return false.
 * 
 * @author rays1
 *
 */
public class L_0116_Jump_Game {

    static class Solution {
        
        public boolean canJump(int[] A) {
            if (A.length <= 1) return true;
            
            int n = A.length;
            int cursor = n-1;
            for (int i = n-2; i >= 0; i--) {
                if (A[i]+i >= cursor) {
                    cursor = i;
                }
            }
            return cursor == 0;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {3, 2, 1, 0, 4};
        Out.p(new Solution().canJump(A));
    }

}
