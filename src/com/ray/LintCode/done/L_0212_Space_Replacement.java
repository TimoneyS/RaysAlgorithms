package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Write a method to replace all spaces in a string with `%20`. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.
 *      
 *      You code should also return the new length of the string after replacement.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: string[] = "Mr John Smith" and length = 13
 *      Output: string[] = "Mr%20John%20Smith" and return 17
 *      Explanation:
 *      The string after replacement should be "Mr%20John%20Smith", you need to change the string in-place and return the new length 17.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: string[] = "LintCode and Jiuzhang" and length = 21
 *      Output: string[] = "LintCode%20and%20Jiuzhang" and return 25
 *      Explanation:
 *      The string after replacement should be "LintCode%20and%20Jiuzhang", you need to change the string in-place and return the new length 25.
 *      ```
 *
 * 挑战：
 *      Do it in-place.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/space-replacement/description
 * @date   2019-07-11 18:31:59
 */
public class L_0212_Space_Replacement {

    static class Solution {
        /**
         * @param string: An array of Char
         * @param length: The true length of the string
         * @return: The true length of new string
         */
         //空格的码：119
        public int replaceBlank(char[] string, int length) {
            // Write your code here
            for(int i = 0 ; i < length;i++) {
                
                if(string[i] == ' '){
                    
                    for(int j = length-1; j > i; j--) {
                        string[j+2] = string[j];
                    }
                    
                    string[i] = '%';
                    string[i+1] = '2';
                    string[i+2] = '0';
                    i += 2;
                    length+=2;
                    
                }
                
            }
            
            // for(int i = length-1 ; i >= 0;i--) {
            //     string[i+1] = string[i];
            // }
            // length += 1;
            
            // char c = 34;
            // string[0] = c;
            // string[length] = c;
            
            // System.out.println(string);
            
            return length;
        }
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
