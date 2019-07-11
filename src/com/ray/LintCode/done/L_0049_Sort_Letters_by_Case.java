package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string which contains only letters. Sort it by lower case first and upper case second.
 *
 * 用例：
 *      ```
 *      Example 1:
 *      	Input:  "abAcD"
 *      	Output:  "acbAD"
 *      
 *      Example 2:
 *      	Input: "ABC"
 *      	Output:  "ABC"
 *      	
 *      ```
 *
 * 挑战：
 *      Do it in one-pass and in-place.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/sort-letters-by-case/description
 * @date   2019-07-11 18:00:46
 */
public class L_0049_Sort_Letters_by_Case {

    static class Solution {
        
        /*
         * @param chars: The letter array you should sort by Case
         * @return: nothing
         */
        public void sortLetters(char[] chars) {
            int N = chars.length;
            
            int l = 0, r = chars.length - 1;
            while (l < r) {
                while (l < N && !isUpper(chars[l])) l++;
                while (r > 0 &&  isUpper(chars[r])) r--;
                if (l >= r) break;
                
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
            }
        }
        
        private boolean isUpper(char c) {
            return c >= 'A' && c <= 'Z';
        }
        
    }
    
    public static void main(String[] args) {
        
        String s = "abAcD";
        char[] chars = s.toCharArray();
        new Solution().sortLetters(chars);
        
        Out.p(chars);
        
        
    }

}
