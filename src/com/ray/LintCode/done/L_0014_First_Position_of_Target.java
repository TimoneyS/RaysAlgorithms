package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个升序排列的数组和一个目标数字，寻找数字第一次出现的索引
 *      
 *      如果不存在，返回 -1
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [1,4,4,5,7,7,8,9,9,10]，1
 *      	Output: 0
 *      	
 *      	Explanation: 
 *      	the first index of  1 is 0.
 *      
 *      Example 2:
 *      	Input: [1, 2, 3, 3, 4, 5, 10]，3
 *      	Output: 2
 *      	
 *      	Explanation: 
 *      	the first index of 3 is 2.
 *      
 *      Example 3:
 *      	Input: [1, 2, 3, 3, 4, 5, 10]，6
 *      	Output: -1
 *      	
 *      	Explanation: 
 *      	Not exist 6 in array.
 *      
 *      ```
 *
 * 挑战：
 *      If the count of numbers is bigger than 2^32, can your code work properly?
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-position-of-target/description
 * @date   2019-07-10 22:36:29
 */
public class L_0014_First_Position_of_Target {

    /**
     * 二分搜索
     * @author rays1
     *
     */
    static class Solution {
    
        public int binarySearch(int[] nums, int target) {
            // write your code here
            int l = 0, h = nums.length - 1;
            int index = -1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (target > nums[mid])
                    l = mid+1;
                else if (target < nums[mid])
                    h = mid-1;
                else {
                    h = mid;
                    index = mid;
                    if (h == l)
                        break;
                }
            }
            return index;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
