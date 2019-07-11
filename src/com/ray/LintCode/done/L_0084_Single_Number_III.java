package com.ray.LintCode.done;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * 描述：
 *      Given `2*n + 2` numbers, every numbers occurs twice except two, find them.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  [1,2,2,3,4,4,5,3]
 *      	Output:  [1,5]
 *      
 *      Example 2:
 *      	Input: [1,1,2,3,4,4]
 *      	Output:  [2,3]
 *      	
 *      ```
 *
 * 挑战：
 *      O(n) time, O(1) extra space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/single-number-iii/description
 * @date   2019-07-11 18:30:00
 */
public class L_0084_Single_Number_III {

    static class Solution {
        /**
         * @param A: An integer array
         * @return: An integer array
         */
        public List<Integer> singleNumberIII(int[] A) {
            // write your code here
            int xor = 0;
            for(int n:A){
                xor ^= n;
            }
            
            int lastBit = xor - (xor & (xor-1));
            int group0 = 0;
            int group1 = 0;
            for(int n:A){
                if((lastBit&n)==0){
                    group0 ^= n;
                }else{
                    group1 ^= n;
                }
            }
            
            return Arrays.asList(new Integer[]{group0, group1});
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
