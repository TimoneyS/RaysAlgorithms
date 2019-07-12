package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a string `S`, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * 用例：
 *      **Example1**
 *      ```
 *      Input: "aacecaaa"
 *      Output: "aaacecaaa"
 *      Explanation:
 *      add an 'a' in front of the input string.
 *      ```
 *      **Example2**
 *      ```
 *      Input: "abcd"
 *      Output: "dcbabcd"
 *      ````
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/shortest-palindrome/description
 * @date   2019-07-11 18:35:23
 */
public class L_0678_Shortest_Palindrome {

    /**
     * 先找到 从首位开始的回文长度，一般算法是 O(n^2)，也可以有线性算法。
     * 
     * 然后将除了回文以外的字符串反向加入 sb
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String convertPalindrome(String str) {
            int index = find(str);
            StringBuilder sb = new StringBuilder();
            for (int i = str.length()-1; i > index; i--) sb.append(str.charAt(i));
            sb.append(str);
            return sb.toString();
        }

        int find (String str) {
            int l = 0, r = str.length() - 1;
            while (r > l) {
                if (str.charAt(r) == str.charAt(l)) {
                    l ++;
                    r --;
                } else {
                    r = r+l-1;
                    l = 0;
                }
            }
            return l + r;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
