package com.ray.LintCode.done;

import java.util.ArrayList;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a **rotated** sorted array, recover it to sorted array in-place.
 *
 * 用例：
 *      **Example1:**
 *      `[4, 5, 1, 2, 3]` -> `[1, 2, 3, 4, 5]`
 *      **Example2:**
 *      `[6,8,9,1,2]` -> `[1,2,6,8,9]`
 *
 * 挑战：
 *      In-place, O(*1*) extra space and O(*n*) time.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/recover-rotated-sorted-array/description
 * @date   2019-07-11 17:51:29
 */
public class L_0039_Recover_Rotated_Sorted_Array {

    static class Solution {
        /**
         * @param nums: The rotated sorted array
         * @return: void
         */
        public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
            int c = nums.size();
            for (int i = 1; i < nums.size(); i ++)
                if (less(nums, i, i-1)) { c = i; break;}
            
            int l = 0,
                r = nums.size()-1;
            int num = 0;
            while (c > l && c <= r) {
                if (c<(l+r+2)/2) {
                    num = c-l;
                    swap(nums, l, c, num);
                    l = c;
                    c = c+num;
                } else {
                    num = r+1-c;
                    swap(nums, l, c, num);
                    l = l+num; 
                }
            }
            
        }
        
        public boolean less(ArrayList<Integer> arr, int i,  int j){
            return arr.get(i).compareTo(arr.get(j)) < 0;
        }
        
        public void swap(ArrayList<Integer> arr, int i, int j) {
            Integer temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        
        public void swap(ArrayList<Integer>arr,  int l1, int l2, int size) {
            for (int i = 0; i < size; i ++)
                swap(arr, l1 + i, l2 + i);
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
