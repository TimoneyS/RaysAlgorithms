package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      The count-and-say sequence is the sequence of integers beginning as follows:
 *      
 *      `1, 11, 21, 1211, 111221, ...`
 *      
 *      `1` is read off as `"one 1"` or `11`.
 *      
 *      `11` is read off as `"two 1s"` or `21`.
 *      
 *      `21` is read off as `"one 2, then one 1"` or `1211`.
 *      
 *      Given an integer `n`, generate the `n`th sequence.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: 1
 *      Output: "1"
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: 5
 *      Output: "111221"
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/count-and-say/description
 * @date   2019-07-11 18:32:51
 */
public class L_0420_Count_and_Say {


    /**
     * 提供 next 方法
     * next方法统计字符串中每段连续字符的长度和字符本身，加入新的字符串中
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String countAndSay(int n) {
            String s = "1";
            for (int i = 1; i < n; i ++) {
                s = next(s);
            }
            return s;
        }
        
        public String next(String s) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 0; i < s.length(); i ++) {
                if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                    count ++;
                } else {
                    sb.append(count).append(s.charAt(i));
                    count = 1;
                }
            }
            return sb.toString();
            
        }
    
    }
    
    public static void main(String[] args) {
        
        int n = 5;
        
        Out.p(new Solution().countAndSay(n));
        
    }

}
