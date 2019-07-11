package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `n` balloons, indexed from `0` to `n-1`. Each balloon is painted with a number on it represented by array `nums`. You are asked to burst all the balloons. If the you burst balloon `i` you will get `nums[left] * nums[i] * nums[right]` coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *      
 *      Find the `maximum` coins you can collect by bursting the balloons wisely.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input：[4, 1, 5, 10]
 *      Output：270
 *      Explanation：
 *      nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
 *      nums = [4, 5, 10]   burst 5, get coins 4 * 5 * 10 = 200 
 *      nums = [4, 10]    burst 4, get coins 1 * 4 * 10 = 40
 *      nums = [10]    burst 10, get coins 1 * 10 * 1 = 10
 *      Total coins 20 + 200 + 40 + 10 = 270
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input：[3,1,5]
 *      Output：35
 *      Explanation：
 *      nums = [3, 1, 5] burst 1, get coins 3 * 1 * 5 = 15
 *      nums = [3, 5] burst 3, get coins 1 * 3 * 5 = 15
 *      nums = [5] burst 5, get coins 1 * 5 * 1 = 5
 *      Total coins 15 + 15 + 5  = 35
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/burst-balloons/description
 * @date   2019-07-11 18:31:29
 */
public class L_0168_Burst_Balloons {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
