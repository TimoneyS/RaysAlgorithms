package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 
 * 未排序的数组，将其排序为如下的情况：
 *      nums[0] < nums[1] > nums[2] < nums[3] ...
 * 
 * 如：
 *      [1, 5, 1, 1, 6, 4] -> [1, 4, 1, 5, 1, 6].
 *      [1, 3, 2, 2, 3, 1] -> [2, 3, 1, 3, 1, 2].
 * 
 * 挑战
 *     时间复杂度 O(n)
 *     或者 空间复杂度 O(1)
 * 
 * @author rays1
 *
 */
public class L_0507_Wiggle_Sort_II {

    /**
     * 先快速搜索，找到中间数
     * 
     * 然后比中间数小的从右侧放入奇数位
     * 比中间数大的从左侧放入偶数位
     * 等于中间数的，放入剩余位置
     * 
     * @author rays1
     *
     */
    static class Solution {
        
        public void wiggleSort(int[] nums) {
            int[] ans = new int[nums.length];
            int mid = quickSelect(nums, nums.length/2, 0, nums.length-1);
            
            Arrays.fill(ans, mid);
            int l, r = 1;
            
            Out.p(mid);
            Out.p(nums);
            
            if (nums.length % 2 == 0) {
                l = nums.length - 2;
            } else {
                l = nums.length - 1;
            } 
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
   
            for (int i = 0; i < nums.length; i++) {
                nums[i] = ans[i];
            }
            
        }
        
        public int quickSelect(int[] nums, int rank, int s, int t) {
            int l = s + 1, r = t;
            while (true) {
                while (r > s && nums[s] <= nums[r]) r --;
                while (l < t && nums[l] < nums[s]) l ++;
                if (r > l) swap(nums, r, l);
                else break;
            }
            swap(nums, r, s);
            
            if (r == rank)
                return nums[r];
            else if (r > rank)
                return quickSelect(nums, rank, s, r-1);
            else 
                return quickSelect(nums, rank, r+1, t);
        }
        
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {4,5,5,6};
        new Solution().wiggleSort(nums);
        Out.p(nums);
    }

}
