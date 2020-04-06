package com.ray.LintCode.tostudy;

import com.ray.io.Out;

/**
 * 描述：
 *      输入一个英文句子，将每个单词的第一个字母改成大写字母
 *
 * 用例：
 *      **用例1**
 *      
 *      ```
 *      输入: s =  "i want to get an accepted"
 *      输出: "I Want To Get An Accepted"
 *      ```
 *      
 *      **用例2**
 *      
 *      ```
 *      输入: s =  "i jidls    mdijf  i  lsidj  i p l   "
 *      输出: "I Jidls    Mdijf  I  Lsidj  I P L   "
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/capitalizes-the-first-letter/description
 * @date   2019-07-19 17:46:02
 */
public class L_0936_Capitalizes_The_First_Letter {

    /**
     * 当字符是小写字母且左侧为空格或者字符串开始时，需要改为大写
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String capitalizesFirst(String s) {
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                
                char c  = s.charAt(i);
                
                if (c >= 97 && c <= 122 && ( i == 0 || s.charAt(i-1) == ' ')) {
                    c = (char)(c - 32);
                }
                sb.append(c);
            }
            
            return sb.toString();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
