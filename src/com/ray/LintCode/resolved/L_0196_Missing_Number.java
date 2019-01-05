package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 *
 * @author rays1
 *
 */
public class L_0196_Missing_Number {

    static class Solution {
        public int findMissing(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 || nums[i] == i+1) continue;
                while (nums[i] > 0 && nums[i] != i+1) {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i+1) return i+1;
            }
            
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {4,0,2,1};
        
        Out.p(new Solution().findMissing(nums));
        
        Out.p(nums);
        
    }

}
