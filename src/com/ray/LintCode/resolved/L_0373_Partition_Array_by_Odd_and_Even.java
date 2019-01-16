package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 将整数数组调整为左边为奇数和右边为偶数
 *
 * @author rays1
 *
 */
public class L_0373_Partition_Array_by_Odd_and_Even {

    static class Solution {
        
        public void partitionArray(int[] nums) {
            int l = 0;
            int r = nums.length-1;
            while (l < r) {
                while (l < nums.length && !isOdd(nums[l])) l++;
                while (r >= 0 && isOdd(nums[r])) r--;
                
                if (l >= nums.length || r <= 0 || l >= r) break;
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
            }
        
        }
        
        public boolean isOdd(int n) {
            return n % 2 == 0;
        }
        
    }
    
    public static void main(String[] args) {
        
//        int[] nums = ArrayUtil.intArr(10);
//        ArrayUtil.shuffle(nums);
//        Out.p(nums);
        
        int[] nums = {1, 2, 3, 4};
        
        
        new Solution().partitionArray(nums);
        
        Out.p(nums);
        
    }

}
