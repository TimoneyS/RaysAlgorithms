package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of *n* objects with *k* different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: 
 *      [3,2,2,1,4] 
 *      4
 *      Output: 
 *      [1,2,2,3,4]
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: 
 *      [2,1,1,2,2] 
 *      2
 *      Output: 
 *      [1,1,2,2,2]
 *      ```
 *
 * 挑战：
 *      A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-colors-ii/description
 * @date   2019-07-11 18:31:08
 */
public class L_0143_Sort_Colors_II {

    static class Solution {
        /**
         * @param colors: A list of integer
         * @param k: An integer
         * @return: nothing
         */
        public void sortColors2(int[] colors, int k) {
            Arrays.sort(colors);
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
