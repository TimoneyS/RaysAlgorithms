package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Validate if a given string is numeric.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: "0"
 *      Output: true
 *      Explanation: "0" can be converted to 0
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: "0.1"
 *      Output: true
 *      Explanation: "0.1" can be converted to 0.1
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: "abc"
 *      Output: false
 *      ```
 *      
 *      **Example 4:**
 *      
 *      ```
 *      Input: "1 a"
 *      Output: false
 *      ```
 *      
 *      **Example 5:**
 *      
 *      ```
 *      Input: "2e10"
 *      Output: true
 *      Explanation: "2e10" represents 20,000,000,000
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/valid-number/description
 * @date   2019-07-11 18:32:48
 */
public class L_0417_Valid_Number {

    
    /**
     * 跳过字符串开始的所有空格，然后跳过开始的+-符号
     * 跳过字符串结尾的所有空格
     * 
     * 如果字符串包含 e 则判断e两侧都是纯数字
     * 如果字符串包含 . 则判断.两侧至少有一侧是数字，另一侧为空
     * 如果都不包含，则检测字符串为纯数字
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isNumber(String s) {
            
            int l = 0, r = s.length() - 1;
            
            while (l < s.length() && s.charAt(l) == ' ') l++;
            while (r >= 0 && s.charAt(r) == ' ') r--;            
            
            if (l < s.length() && ( s.charAt(l) == '+' || s.charAt(l) == '-') ) l++;
            
            int index = -1;
            
            if ((index = s.indexOf('.')) != -1) {
                
                boolean rs1 = isJustNumber(s, l, index-1);
                boolean rs2 = isJustNumber(s, index+1, r);
                       
                return rs1 && (rs2 || r < index + 1) || (rs1 || l > index-1) && rs2;
            } else if ((index = s.indexOf('e')) != -1) {
                return isJustNumber(s, l, index-1) && isJustNumber(s, index+1, r);
            } else {
                return isJustNumber(s, l, r);
            }
        }
        
        public boolean isJustNumber(String s, int start, int end) {
            Out.pf("%s, %s\n", start, end);
            
            if (start > end) return false;
            
            for (int i = start; i <= end; i ++) {
                char c = s.charAt(i); 
                if ( c < '0' || c > '9') return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        /*      "0"      => true
                " 0.1 "  => true
                "abc"    => false
                "1 a"    => false
                "2e10"   => true
        */
        String s = " +.1";
        
        Out.p(new Solution().isNumber(s));
        
    }

}
