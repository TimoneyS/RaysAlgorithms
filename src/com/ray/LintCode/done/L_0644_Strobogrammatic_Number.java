package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      A mirror number is a number that looks the same when rotated 180 degrees (looked at upside down).For example, the numbers "69", "88", and "818" are all mirror numbers.
 *      
 *      Write a function to determine if a number is mirror. The number is represented as a string.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : "69"
 *      Output : true
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input : "68"
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/strobogrammatic-number/description
 * @date   2019-07-11 18:34:44
 */
public class L_0644_Strobogrammatic_Number {

    static class Solution {
        
        public boolean isStrobogrammatic(String num) {
            
            int[] mirrorOf = new int[10];
            Arrays.fill(mirrorOf, -1);
            
            mirrorOf[0] = 0;
            mirrorOf[1] = 1;
            mirrorOf[6] = 9;
            mirrorOf[6] = 9;
            mirrorOf[8] = 8;
            mirrorOf[9] = 6;
            
            for (int i = 0, j = num.length()-1; i <= num.length()/2; i++, j--) {
                if (mirrorOf[num.charAt(i) - '0'] != num.charAt(j) - '0') return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
